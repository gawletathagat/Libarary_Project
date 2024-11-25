package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.BorrowService;

import java.util.UUID;

@RestController
@RequestMapping("/api/borrow")
public class BorrowController {
    private final BorrowService borrowService;

    @Autowired
    public BorrowController(BorrowService borrowService) {
        this.borrowService = borrowService;
    }

    @PostMapping("/{userId}/{bookId}")
    public ResponseEntity<String> borrowBook(@PathVariable UUID userId, @PathVariable UUID bookId) {
        borrowService.borrowBook(bookId, userId);
        return ResponseEntity.ok("Book borrowed successfully");
    }
}
