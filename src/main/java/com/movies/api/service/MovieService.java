package com.movies.api.service;

import com.movies.api.models.Movie;
import com.movies.api.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id){
        return movieRepository.findById(id);
    }

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId){
        movieRepository.deleteById(movieId);
    }
}
