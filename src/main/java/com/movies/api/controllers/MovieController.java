package com.movies.api.controllers;

import com.movies.api.models.Movie;
import com.movies.api.models.User;
import com.movies.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id){
        return movieService.getMovieById(id)
                .map(movie -> new ResponseEntity<>(movie, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie newMovie = movieService.saveMovie(movie);
        return new ResponseEntity<>(newMovie, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
