package com.example.movieReview.mapper;

import com.example.movieReview.domain.model.User;
import com.example.movieReview.infra.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toDomain(UserEntity entity);
    UserEntity toEntity(User user);
}
