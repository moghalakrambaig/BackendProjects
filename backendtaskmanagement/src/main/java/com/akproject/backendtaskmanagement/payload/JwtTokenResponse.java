package com.akproject.backendtaskmanagement.payload;

import com.akproject.backendtaskmanagement.secutiry.JwtTokenProvider;

public class JwtTokenResponse {
    private String token;
    private String tokenType = "Bearer";

    public JwtTokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
