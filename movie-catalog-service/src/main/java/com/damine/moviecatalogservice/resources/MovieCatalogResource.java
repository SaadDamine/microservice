package com.damine.moviecatalogservice.resources;

import com.damine.moviecatalogservice.models.CatalogItem;
import com.damine.moviecatalogservice.models.Movie;
import com.damine.moviecatalogservice.models.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;
    /*@Autowired
    private WebClient.Builder webClientBuilder;*/

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        //get all rated movies
        UserRatings ratings=restTemplate.getForObject("http://rating-data-service/ratingsdata/users/"+userId,UserRatings.class);

        // For each movie , call movie info services and get details
        return ratings.getUserRatings().stream().map(rating ->{
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating, Movie.class);
            //put theme together
            return new CatalogItem(movie.getName(),"trans des",rating.getRating());})
                .collect(Collectors.toList());
    }
}

 /* List<Rating> ratings= Arrays.asList(
                new Rating("1",4),
                new Rating("2",3)
);*/


  /*Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movies/" + rating)
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();*/

/* return Collections.singletonList(
                new CatalogItem("Transformers","trans des",4)
);*/
