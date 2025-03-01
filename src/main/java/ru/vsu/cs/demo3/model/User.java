package ru.vsu.cs.demo3.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User {
    @Id
    private Long id;
    private String name;
    private String secondName;
    private Integer age;
}
