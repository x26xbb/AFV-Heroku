package com.una.afv.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 *
 * @author AFV 2014 - <a href="mailto:kevin.villalobos.a@gmail.com">Kevin
 * Villalobos</a>
 */
@Path("ssrs")
@Produces("application/json")
public interface SharedServices {

    @GET
    @Path("/status")
    public Response HealthStatus();

    @POST
    @Path("/create_account")
    @Consumes("application/x-www-form-urlencoded")
    public Response CreateAccount(MultivaluedMap<String, String> formParams);

    @POST
    @Path("/login")
    @Consumes("application/x-www-form-urlencoded")
    public Response Login(MultivaluedMap<String, String> formParams);

    @POST
    @Path("/reset_password")
    @Consumes("application/x-www-form-urlencoded")
    public Response ResetPassword(MultivaluedMap<String, String> formParams);

}
