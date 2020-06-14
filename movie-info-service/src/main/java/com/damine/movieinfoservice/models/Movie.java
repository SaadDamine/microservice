package com.damine.movieinfoservice.models;

public class Movie {
    private String name;
    private String movieInfo;

    public Movie(String name, String movieInfo) {
        this.name = name;
        this.movieInfo = movieInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(String movieInfo) {
        this.movieInfo = movieInfo;
    }
}
