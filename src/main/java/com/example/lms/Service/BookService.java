package com.example.lms.Service;

import com.example.lms.Convertors.BookConvertor;
import com.example.lms.Models.Author;
import com.example.lms.Models.Book;
import com.example.lms.Repository.AuthorRepository;
import com.example.lms.Repository.BookRepository;
import com.example.lms.RequestDto.BookRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    public String createBook(BookRequestDto bookRequestDto){
        Book book= BookConvertor.convertDtoToEntity(bookRequestDto);

        //I need to set the author entity
        int authorId= bookRequestDto.getAuthorId();

        //getting the author entity
        Author author= authorRepository.findById(authorId).get();
        book.setAuthor(author);
        // book list also need to be updated

        List<Book> currentListOfBooks=author.getBooksWritten();
        currentListOfBooks.add(book);
        author.setBooksWritten(currentListOfBooks);
        //save the author
        authorRepository.save(author);
        //save the book
//        bookRepository.save(book);
        return "successfully added book";

    }
}
