package com.forbitbd.stdealers.api;
import com.forbitbd.stdealers.models.Dealer;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiClient {

    @POST("/dealer")
    Call<Dealer> register(@Body Dealer data);
}
