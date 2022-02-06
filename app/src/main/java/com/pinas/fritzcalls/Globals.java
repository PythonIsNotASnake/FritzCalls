package com.pinas.fritzcalls;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Globals {
    private static final Globals instance = new Globals();

    private Retrofit retrofit;

    private List<String> calls = new ArrayList<>();

    private Globals() {
       Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        this.retrofit = new Retrofit.Builder().baseUrl("http://192.168.178.29:8085/").addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

    public static Globals getInstance() {
        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public List<String> getCalls() {
        return calls;
    }

    public void setCalls(List<String> calls) {
        this.calls = calls;
    }
}
