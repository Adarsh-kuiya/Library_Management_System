package com.example.lms.Controller;

import com.example.lms.RequestDto.IssueBookRequestDto;
import com.example.lms.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

   @PostMapping("/issueBook")
    public ResponseEntity<String> issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto){
       String result = null;
       try {
           result = transactionService.issueBook(issueBookRequestDto);
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
       return  new ResponseEntity<>(result, HttpStatus.CREATED);
   }
}
