package com.api.tests;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Filter;

public class UpdateProfileTest {

    @Test(description = "Update Profile")
    public void updateProfileTest(){
        //Login to get Auth token
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("Kingsley", "Kingsley"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());
        System.out.println("--------------------------------------------------------------------------");

        //Get User profile data
        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getUsername(),"Kingsley");
        System.out.println("--------------------------------------------------------------------------");

        //Update the profile data
        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .firstName(userProfileResponse.getFirstName())
                .lastName(userProfileResponse.getLastName())
                .email("KingsleyShackleboltCool@yopmail.com")
                .mobileNumber("9876543210")
                .build();
        response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
        System.out.println(response.asPrettyString());
        System.out.println("--------------------------------------------------------------------------");

    }
}
