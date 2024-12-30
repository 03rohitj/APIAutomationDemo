package com.api.tests;

import com.api.base.AuthService;
import com.api.listeners.TestListener;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

@Listeners(TestListener.class)
public class LoginAPITest {

    @Test(description = "Verify if login api is working fine")
    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("Kingsley");
        loginRequest.setPassword("Kingsley");
        AuthService authService = new AuthService();

        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);     //Imp : as() is used to deserialze the json response
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertNotNull(loginResponse.getToken());
        Assert.assertEquals(loginRequest.getUsername(), loginResponse.getUsername());
    }
}
