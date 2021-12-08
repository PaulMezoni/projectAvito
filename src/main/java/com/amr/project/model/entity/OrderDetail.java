package com.amr.project.model.entity;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class OrderDetail {

    private BigDecimal total;
    private String currency;
    private String method;
    private String intent;
    private String description;
    private String country;
    private String city;
    private String index;
    private String street;
    private String house;
    private String buyerName;
    private String buyerPhone;

}
