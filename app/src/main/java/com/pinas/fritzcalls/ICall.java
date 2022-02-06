package com.pinas.fritzcalls;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ICall {

    @Headers("Content-Type: application/json")
    @POST("/fritz/box/calls")
    public Call<JsonElement> getCallList(@Body JsonObject password);

}
