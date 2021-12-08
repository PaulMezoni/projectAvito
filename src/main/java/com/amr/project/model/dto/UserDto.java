package com.amr.project.model.dto;



import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@ToString
public class UserDto {
    private Long id;
    private String username;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private AddressDto address;
    private ImageDto images;
    private List<OrderDto> orders;



}
