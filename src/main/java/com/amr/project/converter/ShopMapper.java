package com.amr.project.converter;

import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Shop;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = AddressMapper.class)
public interface ShopMapper {
    ShopDto shopToDto(Shop shop);

    Shop dtoToShop(ShopDto shopDto);

}
