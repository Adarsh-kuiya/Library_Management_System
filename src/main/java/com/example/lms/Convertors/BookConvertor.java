package com.example.lms.Convertors;

import com.example.lms.Models.Book;
import com.example.lms.RequestDto.BookRequestDto;

public class BookConvertor {
    public static Book convertDtoToEntity(BookRequestDto bookRequestDto){
        Book book=Book.builder().name(bookRequestDto.getName()).genre(bookRequestDto.getGenre()).isIssued(false).
                build();
        return book;
    }
}
