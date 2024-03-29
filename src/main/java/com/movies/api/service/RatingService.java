package com.movies.api.service;

import com.movies.api.models.Movie;
import com.movies.api.models.Rating;
import com.movies.api.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RatingService {
    @Autowired
    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getAllRatings(){
        return ratingRepository.findAll();
    }

    public Optional<Rating> getRatingById(Long id){
        return ratingRepository.findById(id);
    }

    public Rating saveRating(Rating rating){
        return ratingRepository.save(rating);
    }

    public void deleteRating(Long id){
        ratingRepository.deleteById(id);
    }

    public List<Rating> getMovieRatings(Long id){
        return ratingRepository.findAll()
                .stream()
                .filter(rating -> Objects.equals(rating.getMovie().getMovieId(), id))
                .collect(Collectors.toList());
    }
}
