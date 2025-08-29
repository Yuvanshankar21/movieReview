package com.example.movieReview.mapper;

import com.example.movieReview.domain.model.Review;
import com.example.movieReview.infra.entity.ReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    Review toDomain(ReviewEntity entity);
    ReviewEntity toEntity(Review review);
}
