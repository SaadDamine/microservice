package com.damine.moviecatalogservice.resources;

import com.damine.moviecatalogservice.models.CatalogItem;
import com.damine.moviecatalogservice.models.Movie;
import com.damine.moviecatalogservice.models.Rating;
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
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        WebClient

        //get all rated movies
        List<Rating> ratings= Arrays.asList(
                new Rating("1",4),
                new Rating("2",3)
        );

        // For each movie , call movie info services and get details

        return ratings.stream().map(rating ->{
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating, Movie.class);
            return new CatalogItem(movie.getName(),"trans des",rating.getRating());})
                .collect(Collectors.toList());

        //put theme together

       /* return Collections.singletonList(
                new CatalogItem("Transformers","trans des",4)
        );*/
    }
}
