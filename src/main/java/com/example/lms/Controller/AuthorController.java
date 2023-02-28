package com.example.lms.Controller;

import com.example.lms.Models.Author;
import com.example.lms.RequestDto.AuthorRequestDto;
import com.example.lms.ResponseDto.AuthorResponseDto;
import com.example.lms.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/create")
    public ResponseEntity<String>  createAuthor(@RequestBody()AuthorRequestDto authorRequestDto){
        String result= authorService.createAuthor(authorRequestDto);
        return  new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @GetMapping("/findBy/{name}")
    public List<AuthorResponseDto> findByName(@PathVariable String name){
        return authorService.findByName(name);
    }
}
