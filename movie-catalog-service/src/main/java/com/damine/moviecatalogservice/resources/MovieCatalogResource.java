package com.damine.moviecatalogservice.resources;

import com.damine.moviecatalogservice.models.CatalogItem;
import com.damine.moviecatalogservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
        //get all rated movies
        List<Rating> ratings= Arrays.asList(
                new Rating("1",4),
                new Rating("2",3)
        );

        // For each movie , call movie info services and get details

        //put theme together

        return Collections.singletonList(
                new CatalogItem("Transformers","trans des",4)
        );
    }
}
