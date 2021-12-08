package com.amr.project.model.entity_refactor;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "reviews_item")
public class ReviewItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dignity; //плюсы
    private String flaw; //минусы
    private String text;
    private Date date;
    private Integer rating;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    private boolean isModerated;
    private boolean isModerateAccept;
    private String moderatedRejectReason;
}
