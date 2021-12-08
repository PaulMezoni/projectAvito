package com.amr.project.webapp.controller;

import com.amr.project.converter.CartItemMapper;
import com.amr.project.converter.CategoryMapper;
import com.amr.project.converter.ItemMapper;
import com.amr.project.converter.ShopMapper;
import com.amr.project.model.dto.CartItemDto;
import com.amr.project.model.dto.CategoryDto;
import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.CartItem;
import com.amr.project.model.entity.Category;
import com.amr.project.model.entity.Item;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.CartItemService;
import com.amr.project.service.abstracts.CategoryService;
import com.amr.project.service.abstracts.ItemService;
import com.amr.project.service.abstracts.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomePageController {

    private final CartItemService cartItemService;
    private final CartItemMapper cartItemMapper;
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;
    private final ItemService itemService;
    private final ItemMapper itemMapper;
    private final ShopService shopService;
    private final ShopMapper shopMapper;


    @RequestMapping("/homepage")
    public String homePage(Model model) {
        List<CartItemDto> cartItemDto = new ArrayList<>();
        List<CartItem> cartItem = cartItemService.getAll();
        cartItem.forEach(s -> cartItemDto.add(cartItemMapper.cartItemToDto(s)));
        model.addAttribute("cartItems", cartItemDto);

        List<CategoryDto> categoryDto = new ArrayList<>();
        List<Category> category = categoryService.getAll();
        category.forEach(s -> categoryDto.add(categoryMapper.categoryToDto(s)));
        model.addAttribute("categoryItems", categoryDto);

        List<ItemDto> itemDto = new ArrayList<>();
        List<Item> item = itemService.getAll();
        item.forEach(s -> itemDto.add(itemMapper.itemToDto(s)));
        model.addAttribute("items", itemDto);

        List<ShopDto> shopDto = new ArrayList<>();
        List<Shop> shop = shopService.getAll();
        shop.forEach(s -> shopDto.add(shopMapper.shopToDto(s)));
        model.addAttribute("cardsPopularShops", shopDto);
        return "index";
    }
}
