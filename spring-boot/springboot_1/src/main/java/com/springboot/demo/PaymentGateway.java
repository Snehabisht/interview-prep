package com.springboot.demo;

import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {
    private final PaymentProperties paymentProperties;

    public PaymentGateway(
            PaymentProperties paymentProperties
    ) {
        this.paymentProperties = paymentProperties;
    }

    public int getRetryCount() {
        return paymentProperties.getRetryCount();
    }

    public String getType() {
        return paymentProperties.getType();
    }

    public boolean isEnabled() {
        return paymentProperties.isEnabled();
    }


    public int getTimeout() {
        return paymentProperties.getTimeout();
    }

}
