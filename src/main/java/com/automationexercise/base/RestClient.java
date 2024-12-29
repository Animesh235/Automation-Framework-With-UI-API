package com.automationexercise.base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import java.util.Map;

import com.framework.utils.LogHelper;
import java.util.logging.Logger;

public class RestClient {

    private static final Logger log = LogHelper.getLogger(RestClient.class);

    public static Response get(String endpoint, Map<String, String> headers) {
        log.info("Executing GET request for endpoint: " + endpoint);
        RequestSpecification request = given();

        if (headers != null && !headers.isEmpty()) {
            request.headers(headers);
        }

        Response response = request.get(endpoint);
        log.info("Response received: " + response.getStatusCode());
        return response;
    }

    public static Response post(String endpoint, Map<String, String> headers, Object body) {
        log.info("Executing POST request for endpoint: " + endpoint);
        RequestSpecification request = given();

        if (headers != null && !headers.isEmpty()) {
            request.headers(headers);
        }

        if (body != null) {
            request.body(body);
        }

        Response response = request.post(endpoint);
        log.info("Response received: " + response.getStatusCode());
        return response;
    }

    public static Response put(String endpoint, Map<String, String> headers, Object body) {
        log.info("Executing PUT request for endpoint: " + endpoint);
        RequestSpecification request = given();

        if (headers != null && !headers.isEmpty()) {
            request.headers(headers);
        }

        if (body != null) {
            request.body(body);
        }

        Response response = request.put(endpoint);
        log.info("Response received: " + response.getStatusCode());
        return response;
    }

    public static Response delete(String endpoint, Map<String, String> headers) {
        log.info("Executing DELETE request for endpoint: " + endpoint);
        RequestSpecification request = given();

        if (headers != null && !headers.isEmpty()) {
            request.headers(headers);
        }

        Response response = request.delete(endpoint);
        log.info("Response received: " + response.getStatusCode());
        return response;
    }
}
