package com.example.movieReview.infra.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("movies")
public record MovieEntity(@Id Long id,
                          String title,
                          String genre,
                          Integer releaseYear) { }
