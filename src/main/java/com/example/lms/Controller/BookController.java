package com.example.lms.Controller;

import com.example.lms.RequestDto.BookRequestDto;
import com.example.lms.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/createBook")
    public ResponseEntity<String> createBook(@RequestBody() BookRequestDto bookRequestDto){
     String result= bookService.createBook(bookRequestDto);
     return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
