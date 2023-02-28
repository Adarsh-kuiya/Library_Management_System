package com.example.lms.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;

@Entity
@Table(name="Student")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;

    @Column(name="school_email",unique = true,nullable = false)
    private String email;

    @Column(columnDefinition = "varchar(255) default 'india'",nullable = false)
    private  String Country;

    private int age;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    public Student(String name, String email, String country, int age) {
        this.name = name;
        this.email = email;
        this.Country = country;
        this.age = age;
    }

    @OneToOne(mappedBy = "student",cascade=CascadeType.ALL)
    private Card card;
}
