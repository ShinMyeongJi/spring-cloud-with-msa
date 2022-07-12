package com.shinmj.bookservice.service;

import com.shinmj.bookservice.domain.Book;


public interface BookService {

    Book findBookInfo(Long bookId);
}
