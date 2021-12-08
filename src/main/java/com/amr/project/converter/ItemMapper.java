package com.amr.project.converter;

import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.entity.Category;
import com.amr.project.model.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;


@Mapper(componentModel = "spring", uses = {
        ImageMapper.class, CategoryMapper.class,
        ReviewMapper.class})
public interface ItemMapper {

    @Mapping(source = "shop.id", target = "shopId")
    @Mapping(source = "categories", target = "categoriesName", qualifiedByName = "array")
    @Mapping(source = "shop.name", target = "shopName")
    ItemDto itemToDto(Item item);

    @Mapping(source = "shopId", target = "shop.id")
    @Mapping(source = "shopName", target = "shop.name")
    Item dtoToItem(ItemDto itemDto);

    @Named("array")
    default String[] array(List<Category> categories) {
        String[] array = categories.stream().map(categories1 -> categories1.getName()).toArray(String[]::new);
        return array;
    }
}
