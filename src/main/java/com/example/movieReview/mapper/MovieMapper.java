package com.example.movieReview.mapper;
import com.example.movieReview.domain.model.Movie;
import com.example.movieReview.infra.entity.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(source = "title" , target = "title")
    Movie toDomain(MovieEntity entity);
    MovieEntity toEntity(Movie movie);
}