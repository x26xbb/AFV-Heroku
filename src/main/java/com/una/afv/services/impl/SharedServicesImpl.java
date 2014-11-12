package com.una.afv.services.impl;

import com.una.afv.controller.AFVController;
import com.una.afv.profile.Cliente;
import com.una.afv.repositories.ClienteRespository;
import com.una.afv.services.SharedServices;
import com.una.afv.services.base.ServiceBase;
import com.una.afv.vo.ResponseVO;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author AFV 2014 - <a href="mailto:kevin.villalobos.a@gmail.com">Kevin
 * Villalobos</a>
 */
public class SharedServicesImpl extends ServiceBase implements SharedServices {

    @Autowired
    private ClienteRespository clienteRespository;

    @Override
    public Response HealthStatus() {
        return getResponse(ResponseVO.Response(ResponseVO.SUCCESS, "OK"));
    }

    @Override
    public Response CreateAccount(MultivaluedMap<String, String> formParams) {
        String nombre;
        String email;
        String password;
        Cliente cliente = null;
        ResponseVO response = null;
        try {
            nombre = formParams.get("nombre").get(0);
            email = formParams.get("email").get(0);
            password = formParams.get("password").get(0);
            cliente = new Cliente(email, password, nombre);
            cliente = clienteRespository.saveAndFlush(cliente);
            response = ResponseVO.Response(ResponseVO.SUCCESS, "");
            response.getResponseObjects().put(ResponseVO.USER_KEY, cliente);
            return getResponse(response);
        } catch (Exception e) {
            System.err.println("SharedServicesImpl:CreateAccount::" + e.getMessage());
        }
        return getErrorResponse();
    }

    @Override
    public Response Login(MultivaluedMap<String, String> formParams) {
        String email;
        String password;
        Cliente cliente = null;
        try {
            email = formParams.get("email").get(0);
            password = formParams.get("password").get(0);
            cliente = clienteRespository.findByCorreoAndPassword(email, password);
            if (cliente != null) {
                AFVController controller = AFVController.getInstance();
                ResponseVO response = ResponseVO.Response(ResponseVO.SUCCESS, "");
                response.getResponseObjects().put(ResponseVO.TOKEN_KEY, controller.getToken(cliente.getClienteId().toString()));
                response.getResponseObjects().put(ResponseVO.EMAIL_KEY, cliente.getCorreo());
                response.getResponseObjects().put(ResponseVO.USER_KEY, cliente.getClienteId());
                return getResponse(response);
            } else {
                return getResponse(ResponseVO.Response(ResponseVO.NOT_FOUND, "Login Unsucessful"));
            }
        } catch (Exception e) {
            System.err.println("SharedServicesImpl:Login::" + e.getMessage());
        }
        return getErrorResponse();
    }

    @Override
    public Response ResetPassword(MultivaluedMap<String, String> formParams) {
        return getErrorResponse();
    }

}
