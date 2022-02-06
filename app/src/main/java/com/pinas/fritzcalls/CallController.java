package com.pinas.fritzcalls;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CallController {
    private static final CallController instance = new CallController();

    private CallController() {}

    public static CallController getInstance() {
        return instance;
    }

    public void getCallList(String password) {
        Gson gson = new Gson();
        PasswordModel passwordModel = new PasswordModel(password);
        JsonElement userJson = gson.fromJson(passwordModel.toString(), JsonElement.class);
        JsonObject jsonObject = userJson.getAsJsonObject();
        ICall callService = Globals.getInstance().getRetrofit().create(ICall.class);

        try {
            callService.getCallList(jsonObject).enqueue(new Callback<JsonElement>() {
                @Override
                public void onResponse(Call<JsonElement> call, Response<JsonElement> response) {
                    JsonArray elements = response.body().getAsJsonArray();
                    List<String> list = new ArrayList<>();
                    for(JsonElement element : elements){
                        list.add(element.getAsString());
                    }
                    Globals.getInstance().setCalls(list);
                }

                @Override
                public void onFailure(Call<JsonElement> call, Throwable t) {
                    System.out.println(t);
                }
            });
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
