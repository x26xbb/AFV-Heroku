package com.una.afv.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 *
 * @author AFV 2014 - <a href="mailto:kevin.villalobos.a@gmail.com">Kevin
 * Villalobos</a>
 */
@Path("afvrs/{username}/{tokenid}")
public interface AFVServices {

    @GET
    public Response getUser(@PathParam("username") String userName, @PathParam("tokenid") String tokenid);

    @GET
    @Path("/presupuestos")
    public Response getPresupuestos(@PathParam("username") String userName, @PathParam("tokenid") String tokenid);

    @GET
    @Path("/presupuestos/{presupuestoId}")
    public Response getPresupuesto(@PathParam("username") String userName, @PathParam("tokenid") String tokenid, @PathParam("presupuestoId") Integer presupuestoId);

    @POST
    @Path("/presupuestos/add")
    @Consumes("application/x-www-form-urlencoded")
    public Response addPresupuesto(@PathParam("username") String userName, @PathParam("tokenid") String tokenid, MultivaluedMap<String, String> formParams);

    @POST
    @Path("/presupuestos/delete/{presupuestoId}")
    @Consumes("application/x-www-form-urlencoded")
    public Response delPresupuesto(@PathParam("username") String userName, @PathParam("tokenid") String tokenid, @PathParam("presupuestoId") Integer presupuestoId);

    @GET
    @Path("/presupuestos/{presupuestoId}/categorias")
    public Response getCategorias(@PathParam("username") String userName, @PathParam("tokenid") String tokenid, @PathParam("presupuestoId") Integer presupuestoId);

    @GET
    @Path("/presupuestos/{presupuestoId}/categorias/{categoriaId}")
    public Response getCategoria(@PathParam("username") String userName, @PathParam("tokenid") String tokenid, @PathParam("presupuestoId") Integer presupuestoId, @PathParam("categoriaId") Integer categoriaId);

    @POST
    @Path("/presupuestos/{presupuestoId}/categorias/add")
    @Consumes("application/x-www-form-urlencoded")
    public Response addCategoria(@PathParam("username") String userName, @PathParam("tokenid") String tokenid, @PathParam("presupuestoId") Integer presupuestoId, MultivaluedMap<String, String> formParams);

    @POST
    @Path("/presupuestos/{presupuestoId}/categorias/delete/{categoriaId}")
    @Consumes("application/x-www-form-urlencoded")
    public Response delCategoria(@PathParam("username") String userName, @PathParam("tokenid") String tokenid, @PathParam("presupuestoId") Integer presupuestoId, @PathParam("categoriaId") Integer categoriaId);

    @GET
    @Path("/presupuestos/{presupuestoId}/categorias/{categoriaId}/gastos")
    public Response getGastos(@PathParam("username") String userName, @PathParam("tokenid") String tokenid, @PathParam("presupuestoId") Integer presupuestoId, @PathParam("categoriaId") Integer categoriaId);

    @GET
    @Path("/presupuestos/{presupuestoId}/categorias/{categoriaId}/gastos/{gastoId}")
    public Response getGasto(@PathParam("username") String userName, @PathParam("tokenid") String tokenid, @PathParam("presupuestoId") Integer presupuestoId, @PathParam("categoriaId") Integer categoriaId, @PathParam("gastoId") Integer gastoId);

    @POST
    @Path("/presupuestos/{presupuestoId}/categorias/{categoriaId}/gastos/add")
    @Consumes("application/x-www-form-urlencoded")
    public Response addGasto(@PathParam("username") String userName, @PathParam("tokenid") String tokenid, @PathParam("presupuestoId") Integer presupuestoId, @PathParam("categoriaId") Integer categoriaId, MultivaluedMap<String, String> formParams);

    @POST
    @Path("/presupuestos/{presupuestoId}/categorias/{categoriaId}/gastos/delete/{gastoId}")
    @Consumes("application/x-www-form-urlencoded")
    public Response delGasto(@PathParam("username") String userName, @PathParam("tokenid") String tokenid, @PathParam("presupuestoId") Integer presupuestoId, @PathParam("categoriaId") Integer categoriaId, @PathParam("gastoId") Integer gastoId);

}
