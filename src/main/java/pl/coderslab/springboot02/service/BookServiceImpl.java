package pl.coderslab.springboot02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.springboot02.entity.Book;
import pl.coderslab.springboot02.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    public List<Book> books = new ArrayList<>();

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book get(Long id) {
        return bookRepository.getOne(id);
    }  //  @Override

    //  public void add(Book book) {
    //      bookRepository.save(book);
    //  }    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void update(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.getOne(id);
    }
}
