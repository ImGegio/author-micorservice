package com.author.authormicroservice.controller;

import com.author.authormicroservice.model.AuthorDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/author")
public interface AuthorController {

    @GetMapping(value = "/author-get-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AuthorDto>> getAllAuthors ();

    //A scopo puramente didattico, si potrebbe utilizzare @RequestParam (sarebbe meglio in questo caso)
    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDto> getAuthorByName(@PathVariable("name") String name);

    //TODO al momento di un insert, controllare se autore gia' presente
    @PostMapping(value = "/insert-author", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDto> insertAuthor(@RequestBody AuthorDto authorDto);

    @PutMapping(value = "/update-author", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthorDto> updateAuthor(@RequestBody AuthorDto authorDto);

    @DeleteMapping(value = "/{authorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteAuthor(@PathVariable("authorId") Long authorId);

}
