package repository;

import model.Book;
import model.BorrowTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


    @Repository
    public interface BookRepository extends JpaRepository<Book, UUID>{
        List<Book> findTitleContaining(String title);

        Optional<Book> findById(UUID bookId);
    }

