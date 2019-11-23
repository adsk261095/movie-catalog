package com.github.aman.moviecatalog.moviecatalogservice.models;

public class Movie {

    private String name, movieId;

    public Movie(){
        //creating empty constructor so that object can be made by
        //restTemplate.getForObject
    }
    public Movie(String name, String movieId) {
        this.name = name;
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
