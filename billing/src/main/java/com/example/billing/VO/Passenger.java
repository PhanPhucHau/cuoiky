package com.example.billing.VO;

import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Passenger {
    private int passengerId;
    private String name, address;
}