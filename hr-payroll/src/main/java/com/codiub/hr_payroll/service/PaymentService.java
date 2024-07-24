package com.codiub.hr_payroll.service;

import com.codiub.hr_payroll.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, Integer days) {
        return new Payment("Bob", 200.0, days);
    }
}
