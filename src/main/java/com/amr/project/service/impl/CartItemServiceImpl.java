package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.CartItemDao;
import com.amr.project.model.entity.CartItem;
import com.amr.project.service.abstracts.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl extends ReadWriteServiceImpl<CartItem, Long> implements CartItemService {

    private final CartItemDao cartItemDao;

    @Autowired
    protected CartItemServiceImpl(CartItemDao cartItemDao) {
        super(cartItemDao);
        this.cartItemDao = cartItemDao;
    }
}
