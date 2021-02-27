package com.example.hw02.validation;


import com.example.hw02.model.Book;
import com.example.hw02.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookValidator {
    private final BookRepository bookRepository;

    public String validateNewBook(final Book newBook) {
        if (bookRepository.isIsbnExists(newBook.getIsbn())) {
            return "error-page";
        }
        return "main";
    }

}
