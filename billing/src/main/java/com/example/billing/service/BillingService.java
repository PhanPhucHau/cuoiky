package com.example.billing.service;

import com.example.billing.VO.Passenger;
import com.example.billing.VO.ResponseTemplateVO;
import com.example.billing.entity.Billing;
import com.example.billing.repository.BillingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
@RequiredArgsConstructor
public class BillingService {
    @Autowired
    private BillingRepository billingRepository;
    @Autowired
    private RestTemplate restTemplate;

    public Billing saveBilling(Billing billing) {
        return billingRepository.save(billing);

    }

    public ResponseTemplateVO getBillingWithPassenger(int billId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Billing billing = billingRepository.findById(billId).get();
        Passenger passenger = restTemplate.getForObject("http://localhost:8082/passenger/" + billing.getPassengerId(),
                Passenger.class);
        vo.setBilling(billing);
        vo.setPassenger(passenger);
        return vo;
    }
}
