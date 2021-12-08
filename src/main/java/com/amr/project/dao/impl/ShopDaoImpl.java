package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.ShopDao;
import com.amr.project.model.entity.Shop;
import com.amr.project.util.QueryResultWrapper;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ShopDaoImpl extends ReadWriteDaoImpl<Shop, Long> implements ShopDao {

    @Override
    public Shop getShop(String nameShop) {
        TypedQuery<Shop> shop = (TypedQuery<Shop>) entityManager.createQuery("select u from Shop u where u.name=:nameShop");
        shop.setParameter("nameShop", nameShop);
        return QueryResultWrapper.wrapGetSingleResult(shop);
    }

    @Override
    @Transactional
    public List<Shop> getUnmoderatedShops() {
        return entityManager.createQuery("SELECT s FROM Shop s WHERE s.isModerateAccept = false AND s.isModerated = false", Shop.class)
                .getResultList();
    }

    @Override
    @Transactional
    public List<Shop> getModeratedShops() {
        return entityManager.createQuery("SELECT s FROM Shop s WHERE s.isModerateAccept = true AND s.isModerated = true ", Shop.class)
                .getResultList();
    }
}
