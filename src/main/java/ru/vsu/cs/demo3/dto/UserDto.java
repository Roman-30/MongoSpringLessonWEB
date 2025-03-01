package ru.vsu.cs.demo3.dto;

import lombok.Data;

@Data
/*Можно и UserDTO*/
public class UserDto implements UserView {
    private Long id;
    private String name;
    private String secondName;
    private Integer age;
}
