package com.amr.project.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import springfox.documentation.annotations.ApiIgnore;

import javax.persistence.*;

@Entity
@Table(name = "image")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiIgnore
@Builder
public class Image {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String url;
    @Lob
    @Column(length = Integer.MAX_VALUE)
    private byte[] picture;

    @Column(name = "is_main")
    private Boolean isMain = false;

    @JsonIgnore
    @OneToOne(mappedBy = "images", cascade = {CascadeType.PERSIST})
    private User user;

}
