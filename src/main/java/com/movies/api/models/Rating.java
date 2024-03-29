package com.movies.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long ratingId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private Movie movie;

    @Column(name = "rating")
    private Float ratingValue;

    public Rating() {
    }

    public Rating(User user, Movie movie, Float ratingValue) {
        this.user = user;
        this.movie = movie;
        this.ratingValue = ratingValue;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }

    public Float getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(Float ratingValue) {
        this.ratingValue = ratingValue;
    }
}
