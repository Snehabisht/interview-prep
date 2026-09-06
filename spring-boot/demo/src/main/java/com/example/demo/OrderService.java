package com.example.demo;

public class OrderService {

    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    private PaymentService paymentService;

//    OrderService(PaymentService paymentService){
//        this.paymentService = paymentService;
//        System.out.println("Order service created");
//    }

    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order has been placed");
    }
}
