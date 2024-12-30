package com.api.tests;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {

    @Test(description = "Verify New Account Creation API is working")
    public void createAccountTest(){

        //Using Builder pattern
        SignUpRequest signUpRequest = new SignUpRequest.Builder().username("Dumblydore"+Math.random())
                .email("albuspercivalwulfricbriandumbledore+"+Math.random()+"+@yopmail.com")
                .firstName("Albus")
                .lastName("Dumbledore")
                .mobileNumber("1234567890")
                .password("SherbetLemon").build();
        AuthService authService = new AuthService();
        Response signUpResponse = authService.signUp(signUpRequest);
        Assert.assertEquals(signUpResponse.asPrettyString(),"User registered successfully!");
        System.out.println(signUpResponse.asPrettyString());
    }
}
