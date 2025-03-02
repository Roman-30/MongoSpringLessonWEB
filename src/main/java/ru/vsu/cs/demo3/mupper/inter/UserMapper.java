package ru.vsu.cs.demo3.mupper.inter;

import ru.vsu.cs.demo3.dto.UserDto;
import ru.vsu.cs.demo3.dto.UserCreateDto;
import ru.vsu.cs.demo3.model.User;

public interface UserMapper {

    UserDto modelToDto(User user);

    User dtoToModel(UserDto userDto);

    User updateToModel(UserCreateDto userCreateDto);
}
