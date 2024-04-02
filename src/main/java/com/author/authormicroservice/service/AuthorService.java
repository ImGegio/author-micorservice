package com.author.authormicroservice.service;


import com.author.authormicroservice.model.AuthorDto;

import java.util.List;

public interface AuthorService {
    public List<AuthorDto> getAllAuthors ();

    public AuthorDto getAuthorByName(String name);

    public AuthorDto insertAuthor(AuthorDto authorDto);

    public AuthorDto updateAuthor(AuthorDto authorDto);

    public void  deleteAuthor (Long authorId);
}
