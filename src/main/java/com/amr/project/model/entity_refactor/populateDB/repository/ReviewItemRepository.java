package com.amr.project.model.entity_refactor.populateDB.repository;

import com.amr.project.model.entity_refactor.ReviewItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewItemRepository extends JpaRepository<ReviewItem, Long> {
}
