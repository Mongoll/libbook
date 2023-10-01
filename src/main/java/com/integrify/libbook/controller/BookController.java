package com.integrify.libbook.controller;

import java.util.List;
import java.util.Optional;
import com.integrify.libbook.bean.Book;
import com.integrify.libbook.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/books")
public class BookController {
	private BookRepository bookRepository;
	public BookController(BookRepository bookRepository) {
			this.bookRepository = bookRepository;
		}

	@GetMapping("/all")
	public List<Book> getAllBook() {
			List<Book> books = bookRepository.findAll();
		return books;
	}

	@PostMapping("/admin/add")
	public void createBook(@RequestBody Book book) {
			bookRepository.save(book);
	}

	@DeleteMapping("/admin/delete/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") long id) {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			bookRepository.deleteById(id);
			return ResponseEntity.ok("Book with ID " + id + " deleted successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with ID " + id + " not found.");
		}
	}

	@PutMapping("/admin/update")
	public void updateBook(@RequestBody Book book) {
		bookRepository.save(book);
	}

}

