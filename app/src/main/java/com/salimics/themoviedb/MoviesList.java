package com.salimics.themoviedb;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesList {
   // int page;
    private final List<Results> results;

    //public int getPage() {
    //    return page;
    //}

    public List<Results> getResults() {
        return results;
    }

    public MoviesList(int page, List<Results> results) {
        //this.page = page;
        this.results = results;
    }
}

