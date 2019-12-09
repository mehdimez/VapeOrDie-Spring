package com.vapeordie.vapeordie.repository;

import com.vapeordie.vapeordie.model.OrderProduct;
import com.vapeordie.vapeordie.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct,Long> {
    @Query(value = "SELECT * FROM `order_product` WHERE id_user = ?", nativeQuery = true)
    List<OrderProduct> findByUser(Long idUser);
}
