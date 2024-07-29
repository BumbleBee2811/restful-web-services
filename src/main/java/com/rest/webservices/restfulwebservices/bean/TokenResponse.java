package com.rest.webservices.restfulwebservices.bean;

import java.util.Date;

public class TokenResponse {
    private String jwtToken;
    private Date expiry;

    public TokenResponse() {
    }

    public TokenResponse(String jwtToken, Date expiry) {
        this.jwtToken = jwtToken;
        this.expiry = expiry;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }
}
