package com.sfms.app;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by truongnln on 03/23/2018.
 */

public class ApiFactory {
//    public static String API_BASE_URL = "http://10.82.134.131:3000/";
    public static String API_BASE_URL = "http://10.82.136.20:8080/sfms/api/";


    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());


    public static <S> S createApi(Class<S> apiClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(apiClass);
    }
}
