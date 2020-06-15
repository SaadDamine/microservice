package com.damine.ratingdataservice.resources;

import com.damine.ratingdataservice.models.Rating;
import com.damine.ratingdataservice.models.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,4);
    }

    @RequestMapping("users/{userId}")
    public UserRatings getUserRating(@PathVariable("userId") String movieId){
        List<Rating> ratings= Arrays.asList(
                new Rating("1",4),
                new Rating("2",3)
        );
        UserRatings userRatings=new UserRatings();
        userRatings.setUseRatings(ratings);
        return userRatings;
    }
}
