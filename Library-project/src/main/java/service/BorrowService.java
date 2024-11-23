package service;

import exception.BookNotAvailableException;
import exception.ResourceNotFoundException;
import model.Book;
import model.BorrowTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import repository.BookRepository;
import repository.BorrowTransactionRepository;

import java.time.LocalDate;
import java.util.UUID;

public class BorrowService {
    private final BookRepository bookRepository ;
    private final BorrowTransactionRepository transactionRepository;

    @Autowired
    public BorrowService(BookRepository bookRepository, BorrowTransactionRepository transactionRepository) {
        this.bookRepository = bookRepository;
        this.transactionRepository = transactionRepository;
    }

    public void borrowBook(UUID userId, UUID bookId){
        Book book = bookRepository.findById(bookId)
                .orElseThrow(()-> new ResourceNotFoundException("Book not found"));

        if( book.getAvailableCopies() <=0) {
            throw new BookNotAvailableException("No copies available for book " + book.getTitle() );
        }

        book.setAvailableCopies(book.getAvailableCopies() -1);
        bookRepository.save(book);

        //Create and save the borrow transition
        BorrowTransaction transaction = new BorrowTransaction();
        transaction.setUserId(userId);
        transaction.setBookId(bookId);
        transaction.setBorrowDate(LocalDate.now());
        transaction.setReturnDate(null);
        transactionRepository.save(transaction);
    }
}
