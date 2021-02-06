package ru.boost.charity.rest_api.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.boost.charity.rest_api.entity.User;
import ru.boost.charity.rest_api.model.UserModel;

@Mapper(componentModel = "spring")
public interface UserConverter {

    @Mappings({
            @Mapping(target="password", ignore = true),
            @Mapping(target = "roleId", source = "role.id")
    })
    UserModel entityToModel(User user);
}
