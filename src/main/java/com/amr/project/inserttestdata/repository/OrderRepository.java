package com.amr.project.inserttestdata.repository;

import com.amr.project.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
