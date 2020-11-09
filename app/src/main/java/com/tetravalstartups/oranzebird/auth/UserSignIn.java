package com.tetravalstartups.oranzebird.auth;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserSignIn {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("mobile")
    @Expose
    private String mobile;

    /**
     * No args constructor for use in serialization
     */
    public UserSignIn() {
    }

    /**
     * @param mobile
     * @param error
     * @param message
     */
    public UserSignIn(Boolean error, String message, String mobile) {
        super();
        this.error = error;
        this.message = message;
        this.mobile = mobile;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
