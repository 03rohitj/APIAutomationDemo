package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import com.api.models.request.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * BaseService class is a wrapper for RestAssured, i.e. all RestAssured methods will be called here, making it re-usable for child classes
 */
public class BaseService {
    //BASE URI
    //Creating Requests
    //Handling Responses

    private static final String BASE_URL = "http://64.227.160.186:8080";
    private RequestSpecification requestSpecification;              //Req. Specification specifies how the request will look.

    static{
        RestAssured.filters(new LoggingFilter());       //We need to attach the filter only once when the execution starts. Global Config. to RestAssured
    }

    public BaseService(){
        requestSpecification = given().baseUri(BASE_URL);
    }

    protected void setAuthToken(String token){
        requestSpecification.header("Authorization", "Bearer "+token);
    }

    protected Response postRequest(Object payload, String endpoint){            //Object payload to handle different type of POJO classes
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }

    protected Response getRequest(String endpoint){
        return requestSpecification.get(endpoint);
    }

    protected Response putRequest(Object payload, String endpoint){            //Object payload to handle different type of POJO classes
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
    }
}
