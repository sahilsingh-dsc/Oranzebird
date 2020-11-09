package com.tetravalstartups.oranzebird.apis;

import com.tetravalstartups.oranzebird.modules.fragment.model.AllCategory;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RequestInterface {

    @FormUrlEncoded
    @POST("Add-New-User")
    Call<AllCategory> getCategories();


}
