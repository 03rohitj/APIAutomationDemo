package com.api.base;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class AuthService extends BaseService{
    private static final String BASE_PATH = "/api/auth/";       //Base URL for all authentication services(i.e. all Auth APIs)

    public Response login(LoginRequest payload){
        return postRequest(payload,BASE_PATH+"login");
    }

    public Response signUp(SignUpRequest payload){
        return postRequest(payload, BASE_PATH+"signup");
    }

    public Response forgotPassword(String email){
        Map<Object, Object> payload = new HashMap<>();
        payload.put("email",email);
        return postRequest(payload, BASE_PATH+"forgot-password");
    }
}
