package com.salimics.themoviedb;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Servicey {
    private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()); //Конвертер, необходимый для преобразования JSON'а в объекты
    private static Retrofit retrofit = retrofitBuilder.build();

    private static MovieApi movieApi = retrofit.create(MovieApi.class);

    public static MovieApi getMovieApi() {
        return movieApi;
    }


}
