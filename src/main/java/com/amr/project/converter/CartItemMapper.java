package com.amr.project.converter;

import com.amr.project.model.dto.CartItemDto;
import com.amr.project.model.entity.CartItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartItemMapper {
    CartItemDto cartItemToDto(CartItem cartItem);
}
