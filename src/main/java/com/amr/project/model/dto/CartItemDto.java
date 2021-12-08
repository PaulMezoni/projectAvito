package com.amr.project.model.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class CartItemDto {
    private Long id;
    private List<ItemDto> itemDTOList;
    private List<ShopDto> shopDTOS;
    private int quantity;
}
