package com.example.authorbook.repository;

import com.example.authorbook.domain.entity.Author_Book;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface Author_BookRepository {
    Author_Book getById(Integer id);
    Collection<Author_Book> getAll();
    int save(Author_Book author_book);

    /**
     * if the element is not found, return -1.
     * @param id
     * @return
     *  id or -1
     */
    int removeById(Integer id);
}
