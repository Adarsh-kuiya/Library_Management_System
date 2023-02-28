package com.example.lms.ResponseDto;

import com.example.lms.Enums.Genre;
import lombok.Builder;
import lombok.Data;

@Builder
public class BookResponseDto {
    private String name;
    private Genre genre;
}
