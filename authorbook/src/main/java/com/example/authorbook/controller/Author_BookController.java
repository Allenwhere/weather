package com.example.authorbook.controller;

import com.example.authorbook.domain.dto.Author_BookDTO;
import com.example.authorbook.domain.dto.Author_BookResponseDTO;
import com.example.authorbook.service.Author_BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.authorbook.exception.CommonErrorResponse;
import com.example.authorbook.exception.ResourceNotFoundException;

import javax.transaction.Transactional;
import java.util.Collection;

@RestController
public class Author_BookController {

    private final Author_BookService author_bookService;

    @Autowired
    public Author_BookController(Author_BookService author_bookService) {
        this.author_bookService = author_bookService;
    }

    @GetMapping("/author_book")
    public ResponseEntity<Collection<Author_BookResponseDTO>> getAll() {
        return new ResponseEntity<>(author_bookService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/author_book/{id}")
    public ResponseEntity<Author_BookResponseDTO> getAuthor_BookById(@PathVariable Integer id) {
        return new ResponseEntity<>(author_bookService.getById(id), HttpStatus.OK);
    }


    @PostMapping("/author_book")
    public ResponseEntity<?> createAuthor_Book(@RequestBody Author_BookDTO ab){
        return new ResponseEntity<>(author_bookService.save(ab.getAuthor_book()),HttpStatus.CREATED);
    }


    @PutMapping("/author_book/{id}")
    public ResponseEntity<?> updateAuthor_Book(@PathVariable Integer id, @RequestBody Author_BookDTO ab) {
        return new ResponseEntity<>(author_bookService.save(ab.getAuthor_book()),HttpStatus.OK);
    }


    @DeleteMapping("/author_book/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id) {
        return new ResponseEntity<>(author_bookService.removeById(id),HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundHandler() {
        return new ResponseEntity<>(new CommonErrorResponse("Resource Not Found"), HttpStatus.NOT_FOUND);
    }
}
