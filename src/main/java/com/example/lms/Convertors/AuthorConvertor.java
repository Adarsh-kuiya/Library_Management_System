package com.example.lms.Convertors;

import com.example.lms.Models.Author;
import com.example.lms.RequestDto.AuthorRequestDto;
import com.example.lms.ResponseDto.AuthorResponseDto;

import java.util.ArrayList;
import java.util.List;

public class AuthorConvertor {
    public static Author convertDtoToEntity(AuthorRequestDto authorRequestDto){
   Author author=Author.builder().
           name(authorRequestDto.getName())
           .age(authorRequestDto.getAge())
           .country(authorRequestDto.getCountry())
           .email(authorRequestDto.getEmail())
           .build();

   return  author;
    }


    public static List<AuthorResponseDto> convertEntityToDto(List<Author> authors){

        List<AuthorResponseDto>authorResponseDtoList=new ArrayList<>();

        for(Author author:authors){

            AuthorResponseDto authorResponseDto= AuthorResponseDto.builder().name(author.getName()).id(author.getId()).
                    age(author.getAge()).country(author.getCountry()).email(author.getEmail()).build();
    authorResponseDtoList.add(authorResponseDto);
        }
return authorResponseDtoList;
    }
}
