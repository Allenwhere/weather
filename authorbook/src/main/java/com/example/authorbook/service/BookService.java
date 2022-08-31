package com.example.authorbook.service;

import com.example.authorbook.domain.dto.BookResponseDTO;
import com.example.authorbook.domain.entity.Book;

import java.util.Collection;

public interface BookService {
    BookResponseDTO getById(Integer id);
    Collection<BookResponseDTO> getAll();
    int save(Book book);
    /**
     * if the element is not found, throw exception.
     * @param id
     * @return
     *  id
     */
    int removeById(Integer id);
}
