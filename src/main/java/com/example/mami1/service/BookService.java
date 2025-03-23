package com.example.mami1.service;

import com.example.mami1.dto.BookDTO;
import com.example.mami1.model.Book;
import com.example.mami1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository=bookRepository;
    }

    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(book -> new BookDTO(book.getTitle(), book.getAuthor(),book.getCategory()))
                .collect(Collectors.toList());
    }

    /**
     * 📌 ID’ye göre kitabı getir ve DTO olarak döndür
     */
    public Optional<BookDTO> getBookById(Long id) {
        return bookRepository.findById(id)
                .map(book -> new BookDTO(book.getTitle(), book.getAuthor(),book.getCategory()));
    }

    public Book createBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setCategory(bookDTO.getCategory()); // ❗ Bu satır eksikse NULL gider!
        return bookRepository.save(book);
    }

    public Optional<Book> updateBook(Long id, BookDTO updatedBook) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            Book book = bookOptional.get();
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            return Optional.of(bookRepository.save(book));
        }
        return Optional.empty();
    }

    public boolean deleteBook(Long id){
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
