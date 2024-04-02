package com.author.authormicroservice.entity;

import com.book.microservice.bookmicroservice.utils.DataSourceConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = DataSourceConstants.AUTHOR, schema = DataSourceConstants.SCHEMA )
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    private String name;
    private String surname;
    private String gender;
    private LocalDate dateOfBirth;

    @OneToMany
    private List<Book> books;

}
