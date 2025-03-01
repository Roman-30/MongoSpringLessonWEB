package ru.vsu.cs.demo3.service;

import ru.vsu.cs.demo3.dto.UserDto;
import ru.vsu.cs.demo3.dto.UserSaveDto;
import ru.vsu.cs.demo3.exceprion.UserNotFoundException;
import ru.vsu.cs.demo3.model.User;
import ru.vsu.cs.demo3.mupper.inter.UserMapper;
import ru.vsu.cs.demo3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto saveUser(UserSaveDto userSaveDto) {
        // Валидация, если надо

        /*var можно если имя длинное*/
        User user = userMapper.updateToModel(userSaveDto);

        User savedUser = userRepository.save(user);

        return userMapper.modelToDto(savedUser);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::modelToDto)
                .toList();
    }

    public UserDto getUserById(Long id) throws UserNotFoundException {
        return userRepository.findUserById(id)
                .map(userMapper::modelToDto)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("User for id: {%s} is not found", id)
                ));
    }
}
