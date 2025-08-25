package com.example.movieReview.infra.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("reviews")
public record ReviewEntity(
        @Id Long id,
        int rating,
        String comment,
        Long movieId,
        Long userId
) {}
