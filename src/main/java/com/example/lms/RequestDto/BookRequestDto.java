package com.example.lms.RequestDto;

import com.example.lms.Enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDto {
private  String name;

private Genre genre;

private int authorId;

}
