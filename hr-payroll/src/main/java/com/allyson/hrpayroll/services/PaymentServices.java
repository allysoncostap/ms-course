package com.allyson.hrpayroll.services;


import com.allyson.hrpayroll.entities.Payment;
import com.allyson.hrpayroll.entities.Worker;
import com.allyson.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;





@Service
public class PaymentServices {


@Autowired
private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days){
    Worker worker = workerFeignClient.findById(workerId).getBody();

        return new Payment(worker.getName(),worker.getDailyIncome(),days);
    }
}
