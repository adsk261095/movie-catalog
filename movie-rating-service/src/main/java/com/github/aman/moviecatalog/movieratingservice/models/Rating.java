package com.github.aman.moviecatalog.movieratingservice.models;

public class Rating {
    private String movieId;
    private int rating;
    /**
     * adding an extra filed frequency just to check
     * if adding new field affects the consumer microservices or not
     */
    private int frequency;

    public Rating(String movieId, int rating, int frequency) {
        this.movieId = movieId;
        this.rating = rating;
        this.frequency = frequency;
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

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
