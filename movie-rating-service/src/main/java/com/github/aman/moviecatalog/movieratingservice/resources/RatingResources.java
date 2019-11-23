package com.github.aman.moviecatalog.movieratingservice.resources;

import com.github.aman.moviecatalog.movieratingservice.models.Rating;
import com.github.aman.moviecatalog.movieratingservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingResources {
    @RequestMapping("/{movieId}")
    public Rating getRatings(@PathVariable("movieId") String movieId){
        return new Rating(movieId, 4, 5);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRatings(@PathVariable("userId") String movieId){
        List<Rating> ratings = Arrays.asList(
                new Rating("123", 40, 10),
                new Rating("234", 50, 10)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}
