package com.shinmj.bookservice.service.impl;

import com.shinmj.bookservice.domain.Book;
import com.shinmj.bookservice.repository.BookRepository;
import com.shinmj.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    @Transactional
    public Book findBookInfo(Long bookId) {

        return bookRepository.findById(bookId).get();
    }
}
