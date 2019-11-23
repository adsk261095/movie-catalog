package com.github.aman.moviecatalog.moviecatalogservice.models;

import java.util.List;

public class UserRating {
    private List<Rating> userRating;

    public UserRating(){
        //creating empty constructor so that object can be made by
        //restTemplate.getForObject
    }
    public List<Rating> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }
}
