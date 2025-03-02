package ru.vsu.cs.demo3.controller.api;

import ru.vsu.cs.demo3.dto.UserDto;
import ru.vsu.cs.demo3.dto.UserCreateDto;
import ru.vsu.cs.demo3.exception.UserNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Tag(name = "User API", description = "API для работы с пользователями")
public interface UserApi {
    // Moжно описать специйикацию API
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Пользователь успешно добавлен"
            )
    })
    @Operation(summary = "Добавление нового пользователя")
    UserDto saveUser(@RequestBody UserCreateDto userCreateDto);

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Список пользователей"
            )
    })
    @Operation(summary = "Получение списка пользователей")
    List<UserDto> getAllUsers();
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Пользователь успешно получен"
            )
    })
    @Operation(summary = "Получение пользователя по id")
    UserDto getUserById(@PathVariable Long id) throws UserNotFoundException;
}
