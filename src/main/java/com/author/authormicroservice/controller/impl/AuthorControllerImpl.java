package com.author.authormicroservice.controller.impl;

import com.author.authormicroservice.controller.AuthorController;
import com.author.authormicroservice.model.AuthorDto;
import com.author.authormicroservice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/author")
public class AuthorControllerImpl implements AuthorController {

    @Autowired
    private AuthorService authorService;

    @Override
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

    public ResponseEntity<AuthorDto> getAuthorByName(String name) {
        return new ResponseEntity<>(authorService.getAuthorByName(name), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AuthorDto> insertAuthor(AuthorDto authorDto) {
        return new ResponseEntity<>(authorService.insertAuthor(authorDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AuthorDto> updateAuthor(AuthorDto authorDto) {
        return new ResponseEntity<>(authorService.updateAuthor(authorDto), HttpStatus.OK);
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(Long authorId) {
        authorService.deleteAuthor(authorId);
    }
}
