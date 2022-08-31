package com.example.authorbook.service.impl;

import com.example.authorbook.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.authorbook.domain.dto.AuthorResponseDTO;
import com.example.authorbook.domain.entity.Author;
import com.example.authorbook.exception.ResourceNotFoundException;
import com.example.authorbook.repository.AuthorRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {


    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorResponseDTO getById(Integer id) {
        Author a = authorRepository.getById(id);
        if (a == null) {
            throw new ResourceNotFoundException("");
        }
        return new AuthorResponseDTO(a);
    }

    @Override
    public Collection<AuthorResponseDTO> getAll() {
        return authorRepository.getAll()
                .stream()
                .map(AuthorResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public int save(Author author) {
        return authorRepository.save(author);
    }

    /**
     * if the element is not found, throw exception.
     *
     * @param id
     * @return id
     */
    @Transactional
    @Override
    public int removeById(Integer id) {
        int result = authorRepository.removeById(id);
        if (result == -1) {
            throw new ResourceNotFoundException("");
        }
        return result;
    }
}
