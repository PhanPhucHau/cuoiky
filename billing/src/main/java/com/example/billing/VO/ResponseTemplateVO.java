package com.example.billing.VO;

import com.example.billing.entity.Billing;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseTemplateVO {
    private Billing billing;
    private Passenger passenger;
}
