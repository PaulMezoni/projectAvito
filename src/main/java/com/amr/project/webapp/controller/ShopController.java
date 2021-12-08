package com.amr.project.webapp.controller;

import com.amr.project.converter.ItemMapper;
import com.amr.project.converter.ShopMapper;
import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.service.impl.ShopServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
@Controller
@RequestMapping()
@RequiredArgsConstructor
@Validated
public class ShopController {

    private final ShopServiceImpl shopServiceImpl;

    private final ShopMapper shopMapper;
    private final ItemMapper itemMapper;

    @GetMapping("allShops")
    public ResponseEntity<List<ShopDto>> getAllShops() {
        return ResponseEntity.ok(shopServiceImpl.getAll().stream()
                .map(shopMapper::shopToDto)
                .collect(Collectors.toList()));
    }


    @GetMapping(value = "/shop/{id}")
    public String shopPage(Model model,@PathVariable("id") Long id) {

        ShopDto shop = shopMapper.shopToDto(shopServiceImpl.getByKey(id));
        ItemDto ratingItem = shopServiceImpl.getTheMostRatingItem(shop.getItems());
        List<String> images = shopServiceImpl.convertListImages(ratingItem.getImages());
        String logo = shopServiceImpl.convertImage(shop.getLogo());

        model.addAttribute("shop", shop);
        model.addAttribute("images", images);
        model.addAttribute("logo", logo);
        model.addAttribute("ratingItem", ratingItem);

        return "shopPage/shop_page";
    }

    @GetMapping(value = "/shop/{id}/item/{itemId}")
    public String itemPage(Model model,@PathVariable("id") Long shopId,@PathVariable("itemId") Long itemId) {

        ItemDto item = itemMapper.itemToDto(
                shopServiceImpl.getItemById(shopServiceImpl.getByKey(shopId).getItems(),itemId));

        List<String> image = shopServiceImpl.convertListImages(item.getImages());

        model.addAttribute("item",item);
        model.addAttribute("image", image);
        return "shopPage/shop_item_page";
    }

}
