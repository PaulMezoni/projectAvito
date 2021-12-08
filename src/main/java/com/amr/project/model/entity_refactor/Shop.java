package com.amr.project.model.entity_refactor;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String email;

    private String phone;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private City City;

    @OneToMany(mappedBy = "shop", fetch = FetchType.LAZY)
    private Collection<Item> items;

    @OneToOne(fetch = FetchType.LAZY)
    private Image image;

    private int count;
    private double rating;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private boolean isModerated;
    private boolean isModerateAccept;
    private String moderatedRejectReason;
    private boolean isPretendentToBeDeleted = false;

    //поле для подтверждения модератором
    private int activity;

    @Transient
    private MultipartFile file;
}
