package com.amr.project.model.entity_refactor;

import com.amr.project.model.enums.Gender;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Calendar;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private Calendar birthday;
    private boolean activate;
    private String activationCode;

    @Column(unique = true)
    @Length(min = 6, message = "phone number must be at least 11 characters")
    private String phone;

    @Column(unique = true)
    @NotBlank
    @Email(message = "Введите корректный email")
    private String email;

    @Column(unique = true)
    @NotBlank(message = "Введите имя пользователя")
    @Length(min = 4, message = "Имя пользователя должно быть не менее 4 символов")
    private String username;

    @NotBlank(message = "Введите пароль")
    @Length(min = 6, message = "пароль должен быть не менее 6 символов")
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    private Image images;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Collection<Role> roles;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Address> address;

    @OneToMany(mappedBy = "user")
    private Collection<Shop> shop;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Coupon> coupons;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Collection<CartItem> cart;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Collection<Order> orders;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Shop> favoriteShops;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Item> favoriteItems;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return activate;
    }
}
