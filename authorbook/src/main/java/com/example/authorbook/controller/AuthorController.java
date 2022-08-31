package com.example.authorbook.controller;

import com.example.authorbook.domain.dto.AuthorResponseDTO;
import com.example.authorbook.domain.entity.Author;
import com.example.authorbook.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.authorbook.exception.CommonErrorResponse;
import com.example.authorbook.exception.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;
import java.util.Collection;


@RestController
public class AuthorController {


    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public ResponseEntity<Collection<AuthorResponseDTO>> getAll() {
        return new ResponseEntity<>(authorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorResponseDTO> getAuthorById(@PathVariable Integer id) {
        return new ResponseEntity<>(authorService.getById(id), HttpStatus.OK);
    }


    @PostMapping("/authors")
    public ResponseEntity<?> createAuthor(@RequestBody Author author){
        return new ResponseEntity<>(authorService.save(author),HttpStatus.CREATED);
    }


    @PutMapping("/authors/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable Integer id, @RequestBody Author author) {
        return new ResponseEntity<>(authorService.save(author),HttpStatus.OK);
    }

    @DeleteMapping("/authors/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Integer id) {
        return new ResponseEntity<>(authorService.removeById(id),HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundHandler() {
        return new ResponseEntity<>(new CommonErrorResponse("Resource Not Found"), HttpStatus.NOT_FOUND);
    }

}
