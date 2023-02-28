package com.example.lms.Repository;

import com.example.lms.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AuthorRepository extends JpaRepository<Author,Integer> {
    List<Author> findByName(String name);
}
