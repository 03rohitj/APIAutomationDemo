package com.api.base;

import com.api.models.request.ProfileRequest;
import io.restassured.response.Response;

public class UserProfileManagementService extends BaseService{
    private static final String BASE_PATH = "/api/users";


    public Response getProfile(String userToken){
        setAuthToken(userToken);
        return getRequest(BASE_PATH+"/profile");
    }

    public Response updateProfile(String userToken, ProfileRequest payload){
        setAuthToken(userToken);
        return putRequest(payload, BASE_PATH+"/profile");
    }
}
