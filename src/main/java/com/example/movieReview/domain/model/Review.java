package com.example.movieReview.domain.model;

public record Review(Long id,
                     int rating,
                     String comment,
                     Long movieId,
                     Long userId)
{}
