package com.bookstore.Bookstore.service;

import com.bookstore.Bookstore.model.Book;
import com.bookstore.Bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public void rateBook(Long id, int rating) {
        Book book = getBookById(id);
        if (book != null) {
            book.getRatings().add(rating);
            bookRepository.save(book);
        }
    }
}