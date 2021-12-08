package com.amr.project.service.abstracts;

import com.amr.project.model.entity.Order;

public interface OrderService extends ReadWriteService<Order, Long> {

     void changeStatusToPaid(long order_id);
     void changeStatusToSent(long order_id);
     void changeStatusToDelivered(long order_id);
     void changeStatusToCompleted(long order_id);
}
