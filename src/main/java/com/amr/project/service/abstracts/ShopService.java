package com.amr.project.service.abstracts;

import com.amr.project.model.entity.Shop;

import java.util.List;

public interface ShopService extends ReadWriteService<Shop, Long> {
    Shop getShop(String nameShop);
    List<Shop> getUnmoderatedShops();
    List<Shop> getModeratedShops();
}
