package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetProfileRequestTest {

    @Test
    public void getProfileRequest(){

        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("Kingsley", "Kingsley"));
        Assert.assertEquals(response.statusCode(), 200);
        LoginResponse loginResponse = response.as(LoginResponse.class);

        String userToken = loginResponse.getToken();
        System.out.println(userToken);

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(userToken);
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        System.out.println(userProfileResponse);
    }
}
