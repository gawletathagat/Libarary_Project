package Controller;

import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;
import service.BookService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService ;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String title){
        return ResponseEntity.ok(bookService.searchBooks(title));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book>getBookId(@PathVariable UUID id){
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }
}
