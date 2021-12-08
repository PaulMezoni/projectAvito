package com.amr.project.model.entity_refactor.populateDB.repository;

import com.amr.project.model.entity_refactor.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
