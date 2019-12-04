package com.vapeordie.vapeordie.repository;

import com.vapeordie.vapeordie.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct,Long> {
}
