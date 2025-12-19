package com.BookStoreManagment.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book>  findByAuthor(String author);

    List<Book> findByPriceBetween(double minprice , double maxprice);

    List<Book> findByTitleContaining(String keyword);

}
