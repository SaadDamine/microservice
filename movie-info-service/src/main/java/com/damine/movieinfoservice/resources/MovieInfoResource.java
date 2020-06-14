package com.damine.movieinfoservice.resources;

import com.damine.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {
    @RequestMapping("/{moviesId}")
    public Movie getMovieInfo(@PathVariable("moviesId") String moviesId){
        return new Movie(moviesId,"info about the movie");
    }
}
