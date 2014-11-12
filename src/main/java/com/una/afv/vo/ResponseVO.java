package com.una.afv.vo;

import com.google.gson.annotations.Expose;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author AFV 2014 - <a href="mailto:kevin.villalobos.a@gmail.com">Kevin
 * Villalobos</a>
 */
public class ResponseVO {

    
    public static String TOKEN_KEY = "token";
    public static String USER_KEY = "user";
    public static String EMAIL_KEY = "email";
    
    public static String SUCCESS = "000";
    public static String NOT_FOUND = "404";
    public static String SERVER_ERROR = "403";

    @Expose
    private String codeResponse;
    
    @Expose
    private String messageResponse;
    
    @Expose
    private Map<String, Object> responseObjects;

    public ResponseVO(String codeResponse, String messageResponse) {
        this.codeResponse = codeResponse;
        this.messageResponse = messageResponse;
        responseObjects = new HashMap<String, Object>();
    }

    public static ResponseVO Response(String codeResponse, String messageResponse) {
        return new ResponseVO(codeResponse, messageResponse);
    }

    /**
     * @return the codeResponse
     */
    public String getCodeResponse() {
        return codeResponse;
    }

    /**
     * @param codeResponse the codeResponse to set
     */
    public void setCodeResponse(String codeResponse) {
        this.codeResponse = codeResponse;
    }

    /**
     * @return the messageResponse
     */
    public String getMessageResponse() {
        return messageResponse;
    }

    /**
     * @param messageResponse the messageResponse to set
     */
    public void setMessageResponse(String messageResponse) {
        this.messageResponse = messageResponse;
    }

    /**
     * @return the responseObjects
     */
    public Map<String, Object> getResponseObjects() {
        return responseObjects;
    }

}
