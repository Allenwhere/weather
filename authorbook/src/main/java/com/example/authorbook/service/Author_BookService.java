package com.example.authorbook.service;

import org.springframework.stereotype.Service;
import com.example.authorbook.domain.dto.Author_BookResponseDTO;
import com.example.authorbook.domain.entity.Author_Book;

import java.util.Collection;

@Service
public interface Author_BookService {
    Author_BookResponseDTO getById(Integer id);
    Collection<Author_BookResponseDTO> getAll();
    int save(Author_Book author_book);
    /**
     * if the element is not found, throw exception.
     * @param id
     * @return
     *  id
     */
    int removeById(Integer id);
}
