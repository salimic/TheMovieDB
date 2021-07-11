package com.salimics.themoviedb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static String JSON_URL = "https://api.themoviedb.org/3/movie/top_rated?api_key=7dfd5de05d325c042b999f83e36b60cd";
    private static String API_KEY = "7dfd5de05d325c042b999f83e36b60cd";
    public List<Results> moviesList;
    RecyclerView recyclerView;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.text);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        recyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieApi movieApi = Servicey.getMovieApi();
                Call<Results> responeCall = movieApi.getMovie(550, API_KEY);
                responeCall.enqueue(new Callback<Results>() {
                    @Override
                    public void onResponse(Call<Results> call, Response<Results> response) {
                        if (response.code() == 200) {
                            Results results = response.body();
                            Log.v("Tag", "Responsed " + results.getOriginal_title());
                            textView.setText(results.getTitle());
                        } else {
                            try {
                                Log.v("Tag","Error " + response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Results> call, Throwable t) {

                    }
                });

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieApi movieApi = Servicey.getMovieApi();
                Call<MoviesList> responeCall = movieApi.getData(API_KEY);
                responeCall.enqueue(new Callback<MoviesList>() {
                    @Override
                    public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                        if (response.code() == 200) {
                            MoviesList  moviess = response.body();
                            moviesList = moviess.getResults();
                            Log.v("Tag", "Responsed " + moviesList.get(1).getOriginal_title());
                            textView.setText(moviesList.get(1).getOriginal_title());
                            PostsAdapter adapter = new PostsAdapter(moviesList);
                            recyclerView.setAdapter(adapter);
                        } else {
                            try {
                                Log.v("Tag","Error " + response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesList> call, Throwable t) {

                    }
                });

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MovieApi movieApi = Servicey.getMovieApi();
                Call<MoviesList> responeCall = movieApi.getNew(API_KEY);
                responeCall.enqueue(new Callback<MoviesList>() {
                    @Override
                    public void onResponse(Call<MoviesList> call, Response<MoviesList> response) {
                        if (response.code() == 200) {
                            MoviesList  moviess = response.body();
                            moviesList = moviess.getResults();
                            Log.v("Tag", "Responsed " + moviesList.get(1).getOriginal_title());
                            textView.setText(moviesList.get(1).getOriginal_title());
                            PostsAdapter adapter = new PostsAdapter(moviesList);
                            recyclerView.setAdapter(adapter);
                        } else {
                            try {
                                Log.v("Tag","Error " + response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MoviesList> call, Throwable t) {

                    }
                });

            }
        });
    }

}