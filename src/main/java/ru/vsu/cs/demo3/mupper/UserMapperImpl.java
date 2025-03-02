package ru.vsu.cs.demo3.mupper;

import ru.vsu.cs.demo3.dto.UserDto;
import ru.vsu.cs.demo3.dto.UserCreateDto;
import ru.vsu.cs.demo3.model.User;
import ru.vsu.cs.demo3.mupper.inter.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    //А можно не ебаться и подключить Mupstruct
    @Override
    public UserDto modelToDto(User user) {
        if (user == null) {
            return new UserDto();
        }

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSecondName(user.getSecondName());
        userDto.setAge(user.getAge());

        return userDto;
    }

    @Override
    public User dtoToModel(UserDto userDto) {
        if (userDto == null) {
            return new User();
        }

        User user = new User();

        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSecondName(userDto.getSecondName());
        user.setAge(userDto.getAge());

        return user;
    }

    @Override
    public User updateToModel(UserCreateDto userCreateDto) {
        if (userCreateDto == null) {
            return new User();
        }

        User user = new User();

        user.setId(userCreateDto.getId());
        user.setName(userCreateDto.getName());
        user.setSecondName(userCreateDto.getSecondName());
        user.setAge(userCreateDto.getAge());

        return user;
    }
}