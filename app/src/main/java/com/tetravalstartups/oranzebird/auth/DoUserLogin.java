package com.tetravalstartups.oranzebird.auth;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DoUserLogin {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private Data data;

    /**
     * No args constructor for use in serialization
     */
    public DoUserLogin() {
    }

    /**
     * @param data
     * @param error
     * @param message
     */
    public DoUserLogin(Boolean error, String message, Data data) {
        super();
        this.error = error;
        this.message = message;
        this.data = data;
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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("contact")
        @Expose
        private String contact;
        @SerializedName("fullname")
        @Expose
        private String fullname;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("password")
        @Expose
        private String password;
        @SerializedName("otp")
        @Expose
        private String otp;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("created")
        @Expose
        private String created;

        /**
         * No args constructor for use in serialization
         */
        public Data() {
        }

        /**
         * @param password
         * @param created
         * @param contact
         * @param otp
         * @param id
         * @param fullname
         * @param email
         * @param status
         */
        public Data(String id, String contact, String fullname, String email, String password, String otp, String status, String created) {
            super();
            this.id = id;
            this.contact = contact;
            this.fullname = fullname;
            this.email = email;
            this.password = password;
            this.otp = otp;
            this.status = status;
            this.created = created;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getOtp() {
            return otp;
        }

        public void setOtp(String otp) {
            this.otp = otp;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }
    }
}
