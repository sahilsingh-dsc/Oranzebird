package com.tetravalstartups.oranzebird.modules.fragment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllCategoryData {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("remark")
    @Expose
    private String remark;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("status")
    @Expose
    private String status;

    /**
     * No args constructor for use in serialization
     */
    public AllCategoryData() {
    }

    /**
     * @param image
     * @param createdAt
     * @param remark
     * @param id
     * @param category
     * @param status
     */
    public AllCategoryData(String id, String category, String remark, String image, String createdAt, String status) {
        super();
        this.id = id;
        this.category = category;
        this.remark = remark;
        this.image = image;
        this.createdAt = createdAt;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}