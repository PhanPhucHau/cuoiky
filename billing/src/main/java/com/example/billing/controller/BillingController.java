package com.example.billing.controller;

import com.example.billing.VO.ResponseTemplateVO;
import com.example.billing.service.BillingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class BillingController {
    private final BillingService billingService;

    @GetMapping("/billing/{id}")
    public ResponseTemplateVO getBillingWithPassenger(@PathVariable("id") int id) {
        return billingService.getBillingWithPassenger(id);

    }
}
