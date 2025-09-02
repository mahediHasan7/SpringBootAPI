package com.mahedihasan.store.mappers;

import com.mahedihasan.store.dtos.RegisterUserRequest;
import com.mahedihasan.store.dtos.UpdateUserRequest;
import com.mahedihasan.store.dtos.UserDto;
import com.mahedihasan.store.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    //    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    UserDto toDto(User user);

    User toEntity(RegisterUserRequest user);

    void update(UpdateUserRequest request, @MappingTarget User user);
}
