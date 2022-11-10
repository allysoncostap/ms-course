package com.allyson.hrpayroll.services;


import com.allyson.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentServices {
    public Payment getPayment(long workerId, int days){
        return new Payment("bob",200.0,days);
    }
}
