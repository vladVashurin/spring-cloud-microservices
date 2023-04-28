package com.bill.exeptions;

public class BillNotFoundException extends RuntimeException{
    public BillNotFoundException(String message) {
        super(message);
    }
}
