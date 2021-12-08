package com.amr.project.model.entity;

import com.amr.project.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collection;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "orders_item",
            joinColumns = {@JoinColumn(name = "orders_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private Collection<Item> items;

    @Column
    private Calendar date;

    @Column
    private Status status;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address address;

    @Column
    private BigDecimal total;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name = "buyer_name")
    private String buyerName;

    @Column(name = "buyer_phone")
    private String buyerPhone;

}
