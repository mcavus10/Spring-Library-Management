package com.example.mami1.repository;

import com.example.mami1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    //isme göre kitap bulma
    List<Book> findByTitleContainingIgnoreCase(String title);
    //Yazara göre kitap bulma
    List<Book> findByAuthorContainingIgnoreCase(String author);
}
