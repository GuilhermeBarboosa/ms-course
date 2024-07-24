package com.codiub.hr_payroll.service;

import com.codiub.hr_payroll.feignclient.WorkerFeignClient;
import com.codiub.hr_payroll.entity.Payment;
import com.codiub.hr_payroll.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

//    @Value("${hr-worker.host}")
//    private String workerHost;

    @Autowired
    private WorkerFeignClient workerFeignClient;

//    @Autowired
//    private RestTemplate restTemplate;

    public Payment getPayment(Long workerId, Integer days) {
//        Map<String, String> uriVariables = new HashMap<>();
//        uriVariables.put("id", workerId.toString());
//        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);

        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
