package com.amr.project.model.entity_refactor.populateDB.repository;

import com.amr.project.model.entity_refactor.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
