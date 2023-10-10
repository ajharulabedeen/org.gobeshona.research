package com.javatechie.report.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmountDetailsDto {
    private String sl_no;
    private String product_name;
    private String limit;
    private String outstanding;
    private String expiry;
    private String cummulative_unpaid;
}
