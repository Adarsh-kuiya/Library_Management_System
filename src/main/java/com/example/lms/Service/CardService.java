package com.example.lms.Service;

import com.example.lms.Enums.CardStatus;
import com.example.lms.Models.Card;
import com.example.lms.Models.Student;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    public Card createCard(Student student){

        Card newCard= new Card();
        newCard.setCardStatus(CardStatus.ACTIVATED);
        newCard.setStudent(student);
        return newCard;
    }
}
