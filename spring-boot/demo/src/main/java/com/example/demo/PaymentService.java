package com.example.demo;

public class PaymentService {
    private String type;
    private int retryCount;

    PaymentService(String type, int retryCount) {
        this.type = type;
        this.retryCount = retryCount;
    }

    void pay() {
        System.out.println("payment done with "+ this.type+" and retryed "+ this.retryCount+" times");
    }
}
