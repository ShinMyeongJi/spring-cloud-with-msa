package com.shinmj.rentalservice.domain;

public enum RentalStatus {
    RENTAL_AVALIABLE(0, "대출가능", "대출가능상태"),
    RENTAL_UNAVALIABLE(1, "대출불가", "대출불가능상태");

    RentalStatus(int i, String 대출불가, String 대출불가능상태) {
    }
}
