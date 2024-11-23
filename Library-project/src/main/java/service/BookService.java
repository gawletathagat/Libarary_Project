package service;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BookRepository;

import java.util.List;
import java.util.UUID;


@Service
public class BookService {
   private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> searchBooks( String title) {
        return bookRepository.findTitleContaining(title);
    }

    public Book addBook( Book book){
        return bookRepository.save(book);
    }

    public Book getBookById(UUID bookId){
        return bookRepository.findById(bookId)
                .orElseThrow(()-> new RuntimeException("Book with ID" + bookId +"not found"));
    }





}
