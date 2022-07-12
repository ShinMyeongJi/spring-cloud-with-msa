package com.shinmj.bookservice.api.dto;

import com.shinmj.bookservice.domain.enumeration.BookStatus;
import com.shinmj.bookservice.domain.enumeration.Classification;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class BookDTO {

    private Long id;
    private String bookTitle;
    private String author;
    private String description;
    private String publisher;
    private Long isbn;
    private LocalDate publicationDate;
    private Classification classification;
    private BookStatus bookStatus;
}
