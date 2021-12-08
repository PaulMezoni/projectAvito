package com.amr.project.model.entity_refactor.populateDB.repository;

import com.amr.project.model.entity_refactor.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
