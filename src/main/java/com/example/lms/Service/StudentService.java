package com.example.lms.Service;

import com.example.lms.Enums.CardStatus;
import com.example.lms.Models.Card;
import com.example.lms.Models.Student;
import com.example.lms.Repository.StudentRepository;
import com.example.lms.RequestDto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CardService cardService;
    public String createStudent(StudentRequestDto studentRequestDto){
   //convert DTO to ENTITY layer
        Student student = new Student();
        student.setAge(studentRequestDto.getAge());
        student.setCountry(studentRequestDto.getCountry());
        student.setEmail(studentRequestDto.getEmail());
        student.setName(studentRequestDto.getName());



        student.setCard(cardService.createCard(student));
        studentRepository.save(student);

    return "successfully added student and card";
    }

}
