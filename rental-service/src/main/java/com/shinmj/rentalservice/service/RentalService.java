package com.shinmj.rentalservice.service;

import com.shinmj.rentalservice.domain.Rental;

/**
 * 여기서는 도메인 모델의 책임 범위를 벗어나 도메인 모델에서 "직접" 처리할 수 없는
 * 저장소 처리, 다른 서비스와의 연계 등을 처리한다.
 *
 * 도메인 주도 설계에서는 서비스를 도메인 서비스와 애플리케이션 서비스로 구분하는데,
 * 도메인 서비스는 엔티티 객체나 값 객체에서 수행하기 부자연스럽거나 어색한 행동을 처리한다. (보통 여러 도메인 모델에 걸친 규칙이나 개념)
 * 애플리케이션 서비스에서는 업무처리 흐름을 의미하는 유스케이스 흐름을 처리한다. 여기서 서비스의 역할은 애플리케이션 서비스이다.
 */
public interface RentalService {

    // 도서 대출
    Rental rentBook(Long userId, Long bookId, String bookTitle);
}
