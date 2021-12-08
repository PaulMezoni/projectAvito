package com.amr.project.model.entity_refactor;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Shop shop;

    @ManyToOne
    private User user;

    @Transient
    public BigDecimal getSubTotal() {
        return this.item.getPrice().subtract(BigDecimal.valueOf(this.item.getDiscount())
                        .multiply(this.item.getPrice())
                        .divide(BigDecimal.valueOf(100)))
                .multiply(new BigDecimal(quantity)).setScale(2, RoundingMode.CEILING);
    }
}
