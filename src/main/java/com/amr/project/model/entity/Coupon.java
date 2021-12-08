package com.amr.project.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;

@Entity
@Table(name = "coupon")
@Data
@NoArgsConstructor
@ApiIgnore
public class Coupon {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
