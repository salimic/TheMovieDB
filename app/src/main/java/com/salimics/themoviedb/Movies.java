package com.salimics.themoviedb;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movies implements Parcelable {

    private String vote_count;
    private String title;
    private String overview;


    protected Movies(Parcel in) {
        vote_count = in.readString();
        title = in.readString();
        overview = in.readString();
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };

    public String getVote_count() {
        return vote_count;
    }

    public void setId(String vote_count) {
        this.vote_count = vote_count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String image) {
        this.overview = overview;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(vote_count);
        dest.writeString(title);
        dest.writeString(overview);
    }
}
