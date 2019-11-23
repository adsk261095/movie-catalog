package com.github.aman.moviecatalog.moviecatalogservice.resources;

import com.github.aman.moviecatalog.moviecatalogservice.models.CatalogItem;
import com.github.aman.moviecatalog.moviecatalogservice.models.Movie;
import com.github.aman.moviecatalog.moviecatalogservice.models.Rating;
import com.github.aman.moviecatalog.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    //(autowired is a consumer)
    private RestTemplate restTemplate;
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        //we will create bean of restTemplate object
//        RestTemplate restTemplate = new RestTemplate();

        //get all rated movies id
//        List<Rating> ratings = Arrays.asList(
//          new Rating("123", 4),
//          new Rating("234", 5)
//        );
        System.out.println("userId is: " + userId);

        UserRating userRating = restTemplate.getForObject("http://movie-rating-service/ratings/user/" + userId, UserRating.class);

        for (Rating rating:userRating.getUserRating()
             ) {
            System.out.println(rating.getMovieId() + " " + rating.getRating());
        }
        //get movie information corresponding to these moviesId
        //make REST api call
        return userRating.getUserRating().stream().map(rating -> {

            //getting movie info corresponding to each movie_id

            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            //return catelog corresponding to each movie_object
            return new CatalogItem(movie.getName(), "dance movie dance", rating.getRating());

        }).collect(Collectors.toList());
    }
}
