package com.amr.project.model.entity_refactor.populateDB.repository;

import com.amr.project.model.entity_refactor.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}
