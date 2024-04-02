package com.author.authormicroservice.entity;

import com.author.authormicroservice.utils.DataSourceConstants;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = DataSourceConstants.BOOK, schema = DataSourceConstants.SCHEMA )

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String title;
    private String type;
    private LocalDate yearOfPublication;
    private Integer stock;

    @ManyToOne
    Author author;


}
