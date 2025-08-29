package com.example.movieReview.mapper;
import com.example.movieReview.domain.model.Movie;
import com.example.movieReview.infra.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    @Mapping(source = "title" , target = "title")
    Movie toDomain(MovieEntity entity);
    MovieEntity toEntity(Movie movie);
}