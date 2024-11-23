package repository;

import model.BorrowTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BorrowTransactionRepository extends JpaRepository<BorrowTransaction, UUID> {
}
