package com.vapeordie.vapeordie.repository;

import com.vapeordie.vapeordie.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine,Long> {
}
