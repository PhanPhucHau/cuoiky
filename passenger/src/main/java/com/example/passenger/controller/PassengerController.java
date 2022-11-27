package com.example.passenger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.passenger.entity.Passenger;
import com.example.passenger.service.PassengerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class PassengerController {

    private final PassengerService passengerService;

    @GetMapping("/passenger/{id}")
    public Passenger getPassengerById(@PathVariable("id") int id) {
        return passengerService.getPassengerById(id);
    }
}
