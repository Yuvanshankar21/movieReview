package com.example.movieReview.domain.model;

public record Movie(Long id,
                    String title,
                    String genre,
                    Integer releaseYear)
{}