package com.example.authorbook.repository;

import com.example.authorbook.domain.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BookRepository {
    Book getById(Integer id);
    Collection<Book> getAll();
    int save(Book book);
    /**
     * if the element is not found, return -1.
     * @param id
     * @return
     *  id or -1
     */
    int removeById(Integer id);
}
