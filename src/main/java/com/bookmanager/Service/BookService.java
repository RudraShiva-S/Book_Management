package com.bookmanager.Service;

import com.bookmanager.Entity.Book;
import com.bookmanager.Repository.BookRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

        private final BookRepository bookRepository;

        public BookService(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }

        public Book saveBook(Book book) {
            return bookRepository.save(book);
        }

        public List<Book> getAllBooks() {
            return bookRepository.findAll();
        }

        public Optional<Book> getBookById(Long id) {
            return bookRepository.findById(id);
        }

        public Book updateBook(Long id, Book bookDetails) {
            Book book = bookRepository.findById(id).orElseThrow();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setCategory(bookDetails.getCategory());
            book.setPrice(bookDetails.getPrice());
            return bookRepository.save(book);
        }

        public void deleteBook(Long id) {
            bookRepository.deleteById(id);
        }
    }


