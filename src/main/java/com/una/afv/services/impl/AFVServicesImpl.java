package com.una.afv.services.impl;

import com.una.afv.budget.Categoria;
import com.una.afv.budget.Gasto;
import com.una.afv.budget.Presupuesto;
import com.una.afv.controller.AFVController;
import com.una.afv.profile.Cliente;
import com.una.afv.repositories.CategoriaRespository;
import com.una.afv.repositories.ClienteRespository;
import com.una.afv.repositories.GastoRespository;
import com.una.afv.repositories.PresupuestoRespository;
import com.una.afv.services.AFVServices;
import com.una.afv.services.base.ServiceBase;
import com.una.afv.vo.ResponseVO;
import java.util.List;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author AFV 2014 - <a href="mailto:kevin.villalobos.a@gmail.com">Kevin
 * Villalobos</a>
 */
public class AFVServicesImpl extends ServiceBase implements AFVServices {

    @Autowired
    private ClienteRespository clienteRespository;

    @Autowired
    private PresupuestoRespository presupuestoRespository;

    @Autowired
    private CategoriaRespository categoriaRespository;

    @Autowired
    private GastoRespository gastoRespository;

    @Override
    public Response getUser(String userName, String tokenid) {
        Cliente cliente;
        ResponseVO response;
        try {
            if (AFVController.getInstance().isValidSession(tokenid, userName)) {
                cliente = clienteRespository.findByClienteId(Integer.parseInt(userName));
                response = ResponseVO.Response(ResponseVO.SUCCESS, "");
                response.getResponseObjects().put(ResponseVO.USER_KEY, cliente);

                return getResponse(response);
            }
            //Something when wrong
            return getResponse(ResponseVO.Response(ResponseVO.SERVER_ERROR, "No valid Session"));

        } catch (Exception e) {
            System.err.println("AFVServicesImpl:getUser::" + e.getMessage());
        }
        return getErrorResponse();
    }

    @Override
    public Response getPresupuestos(String userName, String tokenid) {
        Cliente cliente;
        List<Presupuesto> presupuestos;
        try {
            if (AFVController.getInstance().isValidSession(tokenid, userName)) {
                cliente = clienteRespository.findByClienteId(Integer.parseInt(userName));
                presupuestos = presupuestoRespository.findByCliente(cliente);
                ResponseVO response = ResponseVO.Response(ResponseVO.SUCCESS, "");
                response.getResponseObjects().put("presupuestos", presupuestos);

                return getResponse(response);
            }
            //Something when wrong
            return getResponse(ResponseVO.Response(ResponseVO.SERVER_ERROR, "No valid Session"));

        } catch (Exception e) {
            System.err.println("AFVServicesImpl:getPresupuestos::" + e.getMessage());
        }
        return getErrorResponse();
    }

    @Override
    public Response getPresupuesto(String userName, String tokenid, Integer presupuestoId) {
        Presupuesto presupuesto;
        try {
            if (AFVController.getInstance().isValidSession(tokenid, userName)) {
                presupuesto = presupuestoRespository.findByPresupuestoId(presupuestoId);
                ResponseVO response = ResponseVO.Response(ResponseVO.SUCCESS, "");
                response.getResponseObjects().put("presupuesto", presupuesto);
                return getResponse(response);
            }
            //Something when wrong
            return getResponse(ResponseVO.Response(ResponseVO.SERVER_ERROR, "No valid Session"));

        } catch (Exception e) {
            System.err.println("AFVServicesImpl:getPresupuesto::" + e.getMessage());
        }
        return getErrorResponse();
    }

    @Override
    public Response addPresupuesto(String userName, String tokenid, MultivaluedMap<String, String> formParams) {
        String nombre;
        String comentario;
        String ingreso;
        Presupuesto presupuesto;
        Cliente cliente;
        try {

            if (AFVController.getInstance().isValidSession(tokenid, userName)) {
                nombre = formParams.get("nombre").get(0);
                comentario = formParams.get("comentario").get(0);
                ingreso = formParams.get("ingreso").get(0);
                presupuesto = new Presupuesto(nombre, comentario, Long.parseLong(ingreso));
                cliente = clienteRespository.findByClienteId(Integer.parseInt(userName));
                presupuesto.setCliente(cliente);
                presupuesto = presupuestoRespository.saveAndFlush(presupuesto);
                ResponseVO response = ResponseVO.Response(ResponseVO.SUCCESS, "");
                response.getResponseObjects().put("presupuesto", presupuesto);

                return getResponse(response);

            }
            //Something when wrong
            return getResponse(ResponseVO.Response(ResponseVO.SERVER_ERROR, "No valid Session"));

        } catch (Exception e) {
            System.err.println("AFVServicesImpl:addPresupuesto::" + e.getMessage());
        }
        return getErrorResponse();

    }

    @Override
    public Response delPresupuesto(String userName, String tokenid, Integer presupuestoId) {

        try {
            if (AFVController.getInstance().isValidSession(tokenid, userName)) {
                presupuestoRespository.delete(presupuestoId);
                return getResponse(ResponseVO.Response(ResponseVO.SUCCESS, "Erased Successfuly"));
            }
            //Something when wrong
            return getResponse(ResponseVO.Response(ResponseVO.SERVER_ERROR, "No valid Session"));

        } catch (Exception e) {
            System.err.println("AFVServicesImpl:delPresupuesto::" + e.getMessage());
        }
        return getErrorResponse();
    }

    @Override
    public Response getCategorias(String userName, String tokenid, Integer presupuestoId) {
        Presupuesto presupuesto;
        List<Categoria> categorias;
        try {
            if (AFVController.getInstance().isValidSession(tokenid, userName)) {
                presupuesto = presupuestoRespository.findByPresupuestoId(presupuestoId);
                categorias = categoriaRespository.findByPresupuesto(presupuesto);
                ResponseVO response = ResponseVO.Response(ResponseVO.SUCCESS, "");
                response.getResponseObjects().put("categorias", categorias);

                return getResponse(response);
            }
            //Something when wrong
            return getResponse(ResponseVO.Response(ResponseVO.SERVER_ERROR, "No valid Session"));

        } catch (Exception e) {
            System.err.println("AFVServicesImpl:getCategorias::" + e.getMessage());
        }
        return getErrorResponse();
    }

    @Override
    public Response getCategoria(String userName, String tokenid, Integer presupuestoId, Integer categoriaId) {
        Categoria categoria;
        try {
            if (AFVController.getInstance().isValidSession(tokenid, userName)) {
                categoria = categoriaRespository.findByCategoriaId(categoriaId);
                ResponseVO response = ResponseVO.Response(ResponseVO.SUCCESS, "");
                response.getResponseObjects().put("categoria", categoria);
                return getResponse(response);
            }
            //Something when wrong
            return getResponse(ResponseVO.Response(ResponseVO.SERVER_ERROR, "No valid Session"));

        } catch (Exception e) {
            System.err.println("AFVServicesImpl:getCategoria::" + e.getMessage());
        }
        return getErrorResponse();
    }

    @Override
    public Response addCategoria(String userName, String tokenid, Integer presupuestoId, MultivaluedMap<String, String> formParams) {
        String nombre;
        String comentario;
        String porcentaje;
        Categoria categoria;
        Presupuesto presupuesto;

        try {

            if (AFVController.getInstance().isValidSession(tokenid, userName)) {
                nombre = formParams.get("nombre").get(0);
                porcentaje = formParams.get("porcentaje").get(0);
                presupuesto = presupuestoRespository.findByPresupuestoId(presupuestoId);
                categoria = new Categoria(nombre, Integer.parseInt(porcentaje));
                categoria.setPresupuesto(presupuesto);
                categoria = categoriaRespository.saveAndFlush(categoria);
                ResponseVO response = ResponseVO.Response(ResponseVO.SUCCESS, "");
                response.getResponseObjects().put("categoria", categoria);

                return getResponse(response);

            }
            //Something when wrong
            return getResponse(ResponseVO.Response(ResponseVO.SERVER_ERROR, "No valid Session"));

        } catch (Exception e) {
            System.err.println("AFVServicesImpl:addCategoria::" + e.getMessage());
        }
        return getErrorResponse();
    }

    @Override
    public Response delCategoria(String userName, String tokenid, Integer presupuestoId, Integer categoriaId) {
        try {
            if (AFVController.getInstance().isValidSession(tokenid, userName)) {
                categoriaRespository.delete(categoriaId);
                return getResponse(ResponseVO.Response(ResponseVO.SUCCESS, "Erased Successfuly"));
            }
            //Something when wrong
            return getResponse(ResponseVO.Response(ResponseVO.SERVER_ERROR, "No valid Session"));

        } catch (Exception e) {
            System.err.println("AFVServicesImpl:delCategoria::" + e.getMessage());
        }
        return getErrorResponse();
    }

    @Override
    public Response getGastos(String userName, String tokenid, Integer presupuestoId, Integer categoriaId) {
        Categoria categoria;
        List<Gasto> gastos;
        try {
            if (AFVController.getInstance().isValidSession(tokenid, userName)) {
                categoria = categoriaRespository.findByCategoriaId(categoriaId);
                gastos = gastoRespository.findByCategoria(categoria);
                ResponseVO response = ResponseVO.Response(ResponseVO.SUCCESS, "");
                response.getResponseObjects().put("gastos", gastos);

                return getResponse(response);
            }
            //Something when wrong
            return getResponse(ResponseVO.Response(ResponseVO.SERVER_ERROR, "No valid Session"));

        } catch (Exception e) {
            System.err.println("AFVServicesImpl:getGastos::" + e.getMessage());
        }
        return getErrorResponse();
    }

    @Override
    public Response getGasto(String userName, String tokenid, Integer presupuestoId, Integer categoriaId, Integer gastoId) {
        Gasto gasto;
        try {
            if (AFVController.getInstance().isValidSession(tokenid, userName)) {
                gasto = gastoRespository.findByGastoId(gastoId);
                ResponseVO response = ResponseVO.Response(ResponseVO.SUCCESS, "");
                response.getResponseObjects().put("gasto", gasto);
                return getResponse(response);
            }
            //Something when wrong
            return getResponse(ResponseVO.Response(ResponseVO.SERVER_ERROR, "No valid Session"));

        } catch (Exception e) {
            System.err.println("AFVServicesImpl:getGasto::" + e.getMessage());
        }
        return getErrorResponse();
    }

    @Override
    public Response addGasto(String userName, String tokenid, Integer presupuestoId, Integer categoriaId, MultivaluedMap<String, String> formParams) {
        String nombre;
        Long monto;
        Gasto gasto;
        Categoria categoria;

        try {
            if (AFVController.getInstance().isValidSession(tokenid, userName)) {
                nombre = formParams.get("nombre").get(0);
                monto = Long.parseLong(formParams.get("monto").get(0));
                categoria = categoriaRespository.findByCategoriaId(categoriaId);
                gasto = new Gasto(nombre, monto);
                gasto.setCategoria(categoria);
                gasto = gastoRespository.saveAndFlush(gasto);

                ResponseVO response = ResponseVO.Response(ResponseVO.SUCCESS, "");
                response.getResponseObjects().put("gasto", gasto);

                return getResponse(response);

            }
            //Something when wrong
            return getResponse(ResponseVO.Response(ResponseVO.SERVER_ERROR, "No valid Session"));

        } catch (Exception e) {
            System.err.println("AFVServicesImpl:addGasto::" + e.getMessage());
        }
        return getErrorResponse();
    }

    @Override
    public Response delGasto(String userName, String tokenid, Integer presupuestoId, Integer categoriaId, Integer gastoId) {
        try {
            if (AFVController.getInstance().isValidSession(tokenid, userName)) {
                gastoRespository.delete(gastoId);
                return getResponse(ResponseVO.Response(ResponseVO.SUCCESS, "Erased Successfuly"));
            }
            //Something when wrong
            return getResponse(ResponseVO.Response(ResponseVO.SERVER_ERROR, "No valid Session"));

        } catch (Exception e) {
            System.err.println("AFVServicesImpl:delGasto::" + e.getMessage());
        }
        return getErrorResponse();
    }

}
