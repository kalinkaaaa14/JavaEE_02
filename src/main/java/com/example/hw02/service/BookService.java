package com.example.hw02.service;

import com.example.hw02.model.Book;
import com.example.hw02.repository.BookRepository;
import com.example.hw02.validation.BookValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookValidator bookValidator;

    public String createNewBook(final Book newBook) {
        log.info("Try to create new book: {}", newBook.getIsbn());
        String validatorResult = bookValidator.validateNewBook(newBook);
        if(validatorResult.equals("main")) {
            final Book book = bookRepository.saveNewBook(newBook);
            log.info("New book is created: {}", book);
        }
        return validatorResult;
    }

    public Map<String,Book> returnAllBooks(){
        return  bookRepository.returnBooks();
    }

}
