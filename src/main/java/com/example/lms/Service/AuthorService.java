package com.example.lms.Service;

import com.example.lms.Convertors.AuthorConvertor;
import com.example.lms.Models.Author;
import com.example.lms.Repository.AuthorRepository;
import com.example.lms.RequestDto.AuthorRequestDto;
import com.example.lms.ResponseDto.AuthorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorRequestDto authorRequestDto){
        try{
        Author author= AuthorConvertor.convertDtoToEntity(authorRequestDto);
        authorRepository.save(author);
        }
        catch (Exception e){
           log.info("created Author caused an error");
           return "created author did not work";
        }
        return "Author added successfully";
    }

   public List<AuthorResponseDto> findByName(String name){
  List<Author>authors=authorRepository.findByName(name);
List<AuthorResponseDto>authorResponseDto=AuthorConvertor.convertEntityToDto(authors);
  return authorResponseDto;

    }
}
