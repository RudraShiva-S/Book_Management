package com.bookmanager.Controller;

import com.bookmanager.Entity.Book;
import com.bookmanager.Service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

        private final BookService bookService;

        public BookController(BookService bookService) {
            this.bookService = bookService;
        }

        @PostMapping
        public ResponseEntity<Book> createBook(@RequestBody Book book) {
            return ResponseEntity.ok(bookService.saveBook(book));
        }

        @GetMapping
        public ResponseEntity<List<Book>> getAllBooks() {
            return ResponseEntity.ok(bookService.getAllBooks());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Book> getBookById(@PathVariable Long id) {
            return bookService.getBookById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PutMapping("/{id}")
        public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
            return ResponseEntity.ok(bookService.updateBook(id, book));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
        }
    }


