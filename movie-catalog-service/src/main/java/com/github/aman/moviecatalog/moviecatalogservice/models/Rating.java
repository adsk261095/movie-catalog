package com.github.aman.moviecatalog.moviecatalogservice.models;

public class Rating {
    private String movieId;
    private int rating;

    public Rating(){
        //creating empty constructor so that object can be made by
        //restTemplate.getForObject
    }

    public Rating(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
