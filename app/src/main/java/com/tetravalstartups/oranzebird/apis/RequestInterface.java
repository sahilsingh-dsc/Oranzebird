package com.tetravalstartups.oranzebird.apis;

import com.tetravalstartups.oranzebird.auth.DoUserLogin;
import com.tetravalstartups.oranzebird.auth.UserOTP;
import com.tetravalstartups.oranzebird.auth.UserSignIn;
import com.tetravalstartups.oranzebird.modules.fragment.model.AllCategory;
import com.tetravalstartups.oranzebird.modules.fragment.model.GetUserOrder;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RequestInterface {


    @GET("Get-Category")
    Call<AllCategory> getCategories();

    @FormUrlEncoded
    @POST("Get-User-Order")
    Call<GetUserOrder> getUserOrder(@Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("Add-New-User")
    Call<UserSignIn> doUserSignIn(@Field("mobile") String mobile, @Field("fullname") String fullname,
                                  @Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("Verify-User-OTP")
    Call<UserOTP> doUserLogIn(@Field("otp") String otp, @Field("mobile") String mobile);

    @FormUrlEncoded
    @POST("Login-User")
    Call<DoUserLogin> doLogin(@Field("userName") String userName, @Field("password") String password);
}
