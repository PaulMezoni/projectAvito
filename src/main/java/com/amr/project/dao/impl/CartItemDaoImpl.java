package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.CartItemDao;
import com.amr.project.model.entity.CartItem;
import org.springframework.stereotype.Repository;

@Repository
public class CartItemDaoImpl extends ReadWriteDaoImpl<CartItem, Long> implements CartItemDao {

}
