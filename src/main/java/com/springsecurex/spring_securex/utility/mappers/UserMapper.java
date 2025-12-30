package com.springsecurex.spring_securex.utility.mappers;

import com.springsecurex.spring_securex.user.dto.request.CreateUserRequest;
import com.springsecurex.spring_securex.user.dto.response.CreateUserResponse;
import com.springsecurex.spring_securex.user.model.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "middleName", source = "middleName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    User toEntity(CreateUserRequest dto);

    CreateUserResponse toDto(User entity);
}
