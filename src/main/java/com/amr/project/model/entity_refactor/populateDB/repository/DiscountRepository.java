package com.amr.project.model.entity_refactor.populateDB.repository;

import com.amr.project.model.entity_refactor.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
