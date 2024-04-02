package com.author.authormicroservice.mapper;

import com.author.authormicroservice.entity.Author;
import com.author.authormicroservice.model.AuthorDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AuthorMapper {

    /**
     * @return a Author from a AuthorDto
     */
    public Author toEntity(AuthorDto dto) {
        Author entity = new Author();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    /**
     * @return a AuthorDto from a Author
     */
    public AuthorDto toDto(Author entity) {
        AuthorDto dto = new AuthorDto();

        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    /**
     * @return a list of Author from a AuthorDtoList
     */
    public List<Author> toEntity(List<AuthorDto> dto) {
        List<Author> entity = new ArrayList<>();
        for (AuthorDto current : dto) {
            entity.add(toEntity(current)) ;
        }
        return entity;
    }

    /**
     * @return a AuthorDtoList from a list of Author
     */
    public List<AuthorDto> toDto(List<Author> entity) {
        List<AuthorDto> dto = new ArrayList<>();
        for (Author current : entity) {
            dto.add(toDto(current)) ;
        }
        return dto;
    }

    /**
     * @return a AuthorDto from an Optional<Author>
     */
    public AuthorDto optionalToDto(Optional<Author> optional) {
        return toDto(optional.orElse(null));
    }
}
