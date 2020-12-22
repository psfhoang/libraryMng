package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(Long id) {

        return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void updateBook(Book book) {
        Book book1 = bookRepository.getOne(book.getId());
        book1.set(book);
        bookRepository.save(book1);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public boolean isExist(Long id) {
        return bookRepository.findById(id).isPresent();
    }

}
