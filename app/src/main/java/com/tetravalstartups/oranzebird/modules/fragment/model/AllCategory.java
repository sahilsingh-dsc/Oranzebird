package com.tetravalstartups.oranzebird.modules.fragment.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllCategory {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("imagePath")
    @Expose
    private String imagePath;
    @SerializedName("category")
    @Expose
    private List<AllCategoryData> allCategoryData = null;

    /**
     * No args constructor for use in serialization
     */
    public AllCategory() {
    }

    /**
     * @param imagePath
     * @param error
     * @param message
     * @param allCategoryData
     */
    public AllCategory(Boolean error, String message, String imagePath, List<AllCategoryData> allCategoryData) {
        super();
        this.error = error;
        this.message = message;
        this.imagePath = imagePath;
        this.allCategoryData = allCategoryData;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<AllCategoryData> getAllCategoryData() {
        return allCategoryData;
    }

    public void setAllCategoryData(List<AllCategoryData> allCategoryData) {
        this.allCategoryData = allCategoryData;
    }

}