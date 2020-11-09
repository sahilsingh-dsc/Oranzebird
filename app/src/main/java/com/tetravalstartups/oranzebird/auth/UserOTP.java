package com.tetravalstartups.oranzebird.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserOTP {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;

    /**
     * No args constructor for use in serialization
     */
    public UserOTP() {
    }

    /**
     * @param error
     * @param message
     */
    public UserOTP(Boolean error, String message) {
        super();
        this.error = error;
        this.message = message;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
