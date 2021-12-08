package com.amr.project.model.dto;

import lombok.*;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@ToString
public class OrderDto {
    private Collection<ItemDto> items;
}
