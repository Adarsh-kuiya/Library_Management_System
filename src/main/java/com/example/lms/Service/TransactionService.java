package com.example.lms.Service;

import com.example.lms.Enums.CardStatus;
import com.example.lms.Enums.TransactionStatus;
import com.example.lms.Models.Book;
import com.example.lms.Models.Card;
import com.example.lms.Models.Transactions;
import com.example.lms.Repository.BookRepository;
import com.example.lms.Repository.CardRepository;
import com.example.lms.Repository.TransactionRepository;
import com.example.lms.RequestDto.IssueBookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;

    public String issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception{

        //first we will get card and book entity inorder to set the attribute of transaction

        Book book=bookRepository.findById(issueBookRequestDto.getBookId()).get();
        Card card= cardRepository.findById(issueBookRequestDto.getCardId()).get();

        //our final goal is set the attribute of transaction and save it in the repository
        //we need to save all  kind of transaction even id book or card is null then even wew have to save the
        // transaction in the repository

        Transactions transaction= new Transactions();

        //Setting the attributes
        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setIsIssueOperation(true);
        transaction.setTransactionStatus(TransactionStatus.PENDING);


        //attribute left is success/Failure
        //Check for validations
        if(book==null || book.getIsIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available");

        }

        if(card==null || (card.getCardStatus()!= CardStatus.ACTIVATED)){

            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw  new Exception("Card is not valid");
        }



        //We have reached a success case now.

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);


        //set attributes of book
        book.setIsIssued(true);
        //Btw the book and transaction : bidirectional
        List<Transactions> listOfTransactionForBook = book.getListOfTransactions();
        listOfTransactionForBook.add(transaction);
        book.setListOfTransactions(listOfTransactionForBook);


        //I need to make changes in the card
        //Book and the card

        List<Book> issuedBooksForCard = card.getBooksIssued();
        issuedBooksForCard.add(book);
        card.setBooksIssued(issuedBooksForCard);

        for(Book b: issuedBooksForCard){
            System.out.println(b.getName());
        }

        //Card and the Transaction : bidirectional (parent class)
        List<Transactions> transactionsListForCard = card.getListOfTransactions();
        transactionsListForCard.add(transaction);
        card.setListOfTransactions(transactionsListForCard);

        //save the parent.
        cardRepository.save(card);
        //automatically by cascading : book and transaction will be saved.
        //Saving the parent

        return "Book issued successfully";
    }



    }

