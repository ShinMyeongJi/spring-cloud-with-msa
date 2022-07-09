package com.shinmj.rentalservice.exception;

public class RentUnavailableException extends RuntimeException{

    private static final long serialVersionID = 1l;

    public RentUnavailableException() {}

    public RentUnavailableException(String msg) {
        super(msg);
    }
}
