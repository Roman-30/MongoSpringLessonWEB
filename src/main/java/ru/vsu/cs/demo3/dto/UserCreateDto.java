package ru.vsu.cs.demo3.dto;

import lombok.Data;

@Data
public class UserCreateDto {
    private Long id;
    private String name;
    private String secondName;
    private Integer age;
}
