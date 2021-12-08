package com.amr.project.model.entity_refactor;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "orders_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currency;
    private String method;
    private String intent;
    private String description;
    private String country;
    private String city;
    private String cityIndex;
    private String street;
    private String house;
    private String buyerName;
    private String buyerPhone;
}
