package ru.vsu.cs.demo3.controller;

import ru.vsu.cs.demo3.controller.api.UserApi;
import ru.vsu.cs.demo3.dto.UserDto;
import ru.vsu.cs.demo3.dto.UserSaveDto;
import ru.vsu.cs.demo3.exception.UserNotFoundException;
import ru.vsu.cs.demo3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    @PostMapping
    public UserDto saveUser(@RequestBody UserSaveDto userSaveDto) {
        return userService.saveUser(userSaveDto);
    }

    @Override
    @GetMapping("/list")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) throws UserNotFoundException {
        return userService.getUserById(id);
    }
}
