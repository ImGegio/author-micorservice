package com.author.authormicroservice.service.impl;

import com.author.authormicroservice.entity.Author;
import com.author.authormicroservice.mapper.AuthorMapper;
import com.author.authormicroservice.model.AuthorDto;
import com.author.authormicroservice.repository.AuthorRepository;
import com.author.authormicroservice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    /**
     * @return a list of all authors
     */
    @Override
    public List<AuthorDto> getAllAuthors() {
        return authorMapper.toDto(authorRepository.findAll());
    }

    /**
     * @param name of author to search
     * @return author by name
     */
    @Override
    public AuthorDto getAuthorByName(String name) {
        Author author = authorRepository.findByName(name);

        return authorMapper.toDto(author);
    }

    /**
     * @param authorDto
     * @return an instance ok author inserted
     */
    @Override
    public AuthorDto insertAuthor(AuthorDto authorDto) {
        Author savedAuthor = authorRepository.save(authorMapper.toEntity(authorDto));
        return authorMapper.toDto(savedAuthor);
    }

    /**
     * @param authorDto
     * @return an instance ok author updated
     */
    @Override
    public AuthorDto updateAuthor(AuthorDto authorDto) {
        Author updatedAuthor = authorRepository.save(authorMapper.toEntity(authorDto));
        return authorMapper.toDto(updatedAuthor);
    }

    /**
     * @param authorId of author to delete
     */
    @Override
    public void deleteAuthor(Long authorId) {
        Optional<Author> optional = authorRepository.findById(authorId);
        Author author = optional.orElse(null);

        authorRepository.delete(Objects.requireNonNull(author));

    }
}
