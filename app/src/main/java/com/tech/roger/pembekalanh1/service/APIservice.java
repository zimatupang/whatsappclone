package com.tech.roger.pembekalanh1.service;

/**
 * Created by Roger on 5/17/2018.
 */


import com.tech.roger.pembekalanh1.models.User;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Query;

public interface APIservice {

    @GET("whatsapp/get.php")
    Call<User> getUser(@Query("nama")String nama);

    public final String BASE_URL = "192.168.1.10/";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    APIservice service = retrofit.create(APIservice.class);
}
