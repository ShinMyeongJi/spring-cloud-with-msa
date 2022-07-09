package com.shinmj.rentalservice.service;

import com.shinmj.rentalservice.domain.Rental;

public interface ReturnedService {
    // 도서 반납
    Rental returnBooks(Long userId, Long bookId);
}
