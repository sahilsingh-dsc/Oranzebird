package com.tetravalstartups.oranzebird.modules.fragment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetUserOrder {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("order")
    @Expose
    private List<Order> order = null;

    /**
     * No args constructor for use in serialization
     */
    public GetUserOrder() {
    }

    /**
     * @param error
     * @param message
     * @param order
     */
    public GetUserOrder(Boolean error, String message, List<Order> order) {
        super();
        this.error = error;
        this.message = message;
        this.order = order;
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

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }


    public class Order {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("location")
        @Expose
        private String location;
        @SerializedName("address")
        @Expose
        private String address;
        @SerializedName("floor")
        @Expose
        private String floor;
        @SerializedName("state")
        @Expose
        private String state;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("orderTotal")
        @Expose
        private String orderTotal;
        @SerializedName("transaction_id")
        @Expose
        private String transactionId;
        @SerializedName("created_at")
        @Expose
        private String createdAt;

        /**
         * No args constructor for use in serialization
         */
        public Order() {
        }

        /**
         * @param createdAt
         * @param address
         * @param city
         * @param location
         * @param id
         * @param state
         * @param floor
         * @param userId
         * @param orderTotal
         * @param transactionId
         */
        public Order(String id, String userId, String location, String address, String floor, String state, String city, String orderTotal, String transactionId, String createdAt) {
            super();
            this.id = id;
            this.userId = userId;
            this.location = location;
            this.address = address;
            this.floor = floor;
            this.state = state;
            this.city = city;
            this.orderTotal = orderTotal;
            this.transactionId = transactionId;
            this.createdAt = createdAt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getFloor() {
            return floor;
        }

        public void setFloor(String floor) {
            this.floor = floor;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getOrderTotal() {
            return orderTotal;
        }

        public void setOrderTotal(String orderTotal) {
            this.orderTotal = orderTotal;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }
    }

}
