package com.BookStoreManagment.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/books")
    public Book createBooks(@RequestBody Book book){

        Book saveBook = bookRepository.save(book);
        return saveBook;

    }
    @GetMapping("/getbooks")
    public List<Book>  getAllBooks(){

        return bookRepository.findAll();
    }

    @PutMapping("/books/{id}")
    public Book updateBooks(@PathVariable int id, @RequestBody Book book){
        book.setId(id);
        return bookRepository.save(book);
    }


    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id, @RequestBody Book book){
        book.setId(id);
        bookRepository.delete(book);
        return ResponseEntity.ok().build();
    }



}
