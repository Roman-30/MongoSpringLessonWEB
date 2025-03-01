package ru.vsu.cs.demo3.mupper;

import ru.vsu.cs.demo3.dto.UserDto;
import ru.vsu.cs.demo3.dto.UserSaveDto;
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
    public User updateToModel(UserSaveDto userSaveDto) {
        if (userSaveDto == null) {
            return new User();
        }

        User user = new User();

        user.setId(userSaveDto.getId());
        user.setName(userSaveDto.getName());
        user.setSecondName(userSaveDto.getSecondName());
        user.setAge(userSaveDto.getAge());

        return user;
    }
}