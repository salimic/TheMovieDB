package com.salimics.themoviedb;
import android.os.Message;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
    @GET("3/movie/popular?")
    Call<MoviesList> getData (@Query("api_key") String key);

    @GET("3/movie/upcoming?")
    Call<MoviesList> getNew (@Query("api_key") String key);

    @GET("/3/movie/{movie_id}?")
    Call<Results>getMovie(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key
    );

}
