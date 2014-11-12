package com.una.afv.services.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.una.afv.vo.ResponseVO;
import javax.ws.rs.core.Response;

/**
 *
 * @author AFV 2014 - <a href="mailto:kevin.villalobos.a@gmail.com">Kevin
 * Villalobos</a>
 */
public class ServiceBase {

    protected Response getResponse(ResponseVO response) {
        return Response.ok(getGson().toJson(response))
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .build();
    }

    protected Response getErrorResponse() {
        return Response.serverError()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .build();
    }

    protected Gson getGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        return builder.create();
    }
}
