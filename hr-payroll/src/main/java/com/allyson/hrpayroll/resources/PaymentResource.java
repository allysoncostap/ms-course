package com.allyson.hrpayroll.resources;


import com.allyson.hrpayroll.entities.Payment;
import com.allyson.hrpayroll.services.PaymentServices;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentServices services;
@HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
        Payment payment= services.getPayment(workerId,days);
return ResponseEntity.ok(payment);
    }

    public ResponseEntity<Payment> getPaymentAlternative( Long workerId,Integer days){
        Payment payment= new Payment("Brann",400.0,days);
        return ResponseEntity.ok(payment);
    }

}
