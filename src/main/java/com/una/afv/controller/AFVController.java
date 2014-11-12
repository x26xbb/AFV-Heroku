package com.una.afv.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author AFV 2014 - <a href="mailto:kevin.villalobos.a@gmail.com">Kevin
 * Villalobos</a>
 */
public class AFVController {

    Map<String, String> tokens;

    private AFVController() {
        tokens = new HashMap<String, String>();
    }

    private static AFVController controller;

    public synchronized static AFVController getInstance() {
        return (controller != null) ? controller : (controller = new AFVController());
    }

    public boolean isValidSession(String token, String userId) {
        String storedUser = tokens.get(userId);
        return (storedUser != null && !storedUser.isEmpty() && token.equals(storedUser));
    }

    public String getToken(String userId) {
        String guid = UUID.randomUUID().toString().substring(0, 18).replace("-", "_");
        tokens.put(userId, guid);
        return guid;
    }

}
