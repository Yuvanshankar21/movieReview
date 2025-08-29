package com.example.movieReview.mapper;

import com.example.movieReview.domain.model.Movie;
import com.example.movieReview.domain.model.MovieWithReviews;
import com.example.movieReview.domain.model.ReviewWithUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieWithReviewMapper {

    MovieWithReviewMapper INSTANCE = Mappers.getMapper(MovieWithReviewMapper.class);

    @Mapping(source = "movie.title", target = "movieName")
    @Mapping(source = "reviewWithUsers", target = "reviews")
    MovieWithReviews toDomain(Movie movie, List<ReviewWithUser> reviewWithUsers);
}
