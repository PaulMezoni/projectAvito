package com.amr.project.model.entity;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "city")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Api(hidden = true)
@Builder
public class City {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "country_city",
            joinColumns = {@JoinColumn(name = "city_id")},
            inverseJoinColumns = {@JoinColumn(name = "country_id")})
    private Country country;


    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Address> addresses;
}
