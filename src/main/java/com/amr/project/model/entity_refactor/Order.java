package com.amr.project.model.entity_refactor;

import com.amr.project.model.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Item> items;

    private Calendar date;
    private Status status;
    private BigDecimal total;

    @OneToOne(fetch = FetchType.LAZY)
    private OrderDetails orderDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
