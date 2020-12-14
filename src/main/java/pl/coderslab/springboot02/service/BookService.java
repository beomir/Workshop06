package pl.coderslab.springboot02.service;

import pl.coderslab.springboot02.entity.Book;

import java.util.List;



public interface BookService {

    List<Book> getBooks();

    Book findById(Long id);

    void add(Book book);

    Book get(Long id);

    void delete(Long id);

    void update(Book book);
}

