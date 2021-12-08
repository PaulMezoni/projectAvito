package com.amr.project.model.entity_refactor;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;
    private Integer count;
    private Double rating;
    private String description;
    private Integer discount;

    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Image> images;

    private boolean isModerated;
    private boolean isModerateAccept;
    private String moderatedRejectReason;
    private boolean isPretendentToBeDeleted;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Category> categories;

    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

}
