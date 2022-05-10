package com.example.getrequest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String Base_url="https://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit=null;

    public static ApiInterface getRetrofitClient(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(Base_url)
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }
}
