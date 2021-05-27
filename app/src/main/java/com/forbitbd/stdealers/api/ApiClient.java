package com.forbitbd.stdealers.api;
import com.forbitbd.stdealers.models.Dealer;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiClient {

    @POST("/dealer")
    Call<Dealer> register(@Body Dealer data);

    @PUT("/dealer/{email}")
    Call<Dealer> updateDealer(@Path("email") String email, @Body Dealer dealer);

    @GET("/dealer")
    Call<Dealer>is_active();
}
