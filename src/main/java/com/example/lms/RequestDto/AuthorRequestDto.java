package com.example.lms.RequestDto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequestDto {
    private String name;

    private int age;

    private  String country;
    @Column(unique = true)
    private String email;
}
