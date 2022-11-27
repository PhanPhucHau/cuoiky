package com.example.passenger.service;

import org.springframework.stereotype.Service;

import com.example.passenger.entity.Passenger;
import com.example.passenger.repository.PassengerRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public Passenger getPassengerById(int id) {
        try {
            return passengerRepository.findById(id).orElseThrow(() -> new Exception("Not found passenger!"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
