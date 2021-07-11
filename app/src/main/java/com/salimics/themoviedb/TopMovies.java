package com.salimics.themoviedb;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TopMovies {
  /*  private static String JSON_URL = "https://api.themoviedb.org/3/movie/top_rated?api_key=7dfd5de05d325c042b999f83e36b60cd";
    private static String API_KEY = "7dfd5de05d325c042b999f83e36b60cd";
   // public List<MoviesList> moviesList;
    MoviesList res;
    RecyclerView recyclerView;
    private static MovieApi movieApi;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    MovieApi movieDbAPI = retrofit.create(MovieApi.class);

    public void topMovies() {
        // Required empty public constructor
    }

    public void getApi() {
        movieDbAPI.getData(API_KEY).enqueue(new Callback<MoviesList>() {
            @Override
            public void onResponse(@NonNull Call<MoviesList> call, @NonNull Response<MoviesList> response) {
                res = response.body();
                //recyclerView.setAdapter(new TopRatedAdapter(res, 1));
            }

            @Override
            public void onFailure(@NonNull Call<MoviesList> call, @NonNull Throwable t) {
                Log.i("onFailure: ", t.getMessage());
            }
        });
    }*/
}
