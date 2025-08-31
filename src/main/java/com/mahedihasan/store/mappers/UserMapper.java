package com.mahedihasan.store.mappers;

import com.mahedihasan.store.dtos.UserDto;
import com.mahedihasan.store.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    //    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    UserDto toDto(User user);
}
