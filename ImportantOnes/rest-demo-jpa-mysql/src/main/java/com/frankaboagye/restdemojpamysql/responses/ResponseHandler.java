package com.frankaboagye.restdemojpamysql.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus, Object responseObject){

        Map<String , Object> customResponse = new HashMap<>();

        customResponse.put("message", message);
        customResponse.put("httpStatus", httpStatus);
        customResponse.put("data", responseObject);

        return new ResponseEntity<>(customResponse, httpStatus);

    }
}
