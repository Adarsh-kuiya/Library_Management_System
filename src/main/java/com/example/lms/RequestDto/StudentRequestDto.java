package com.example.lms.RequestDto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDto {
    @Column(nullable = false)
    private String name;

    @Column(name="school_email",unique = true,nullable = false)
    private String email;

    @Column(columnDefinition = "varchar(255) default 'india'",nullable = false)
    private  String Country;

    private int age;
}
