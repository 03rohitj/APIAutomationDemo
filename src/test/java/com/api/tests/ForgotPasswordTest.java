package com.api.tests;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

    @Test(description = "Verify Forgot Password API is working fine")
    public void forgotPasswordTest(){
        String successMessage = "If your email exists in our system, you will receive reset instructions.";
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("admin123@yopmail.com");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 200);

    }
}
