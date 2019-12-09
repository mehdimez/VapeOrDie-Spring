package com.vapeordie.vapeordie.service.OrderProduct;

import com.vapeordie.vapeordie.model.OrderProduct;

import java.util.List;

public interface OrderProductService {
    public List<OrderProduct> getAllOrderProduct();
    public OrderProduct updateOrderProduct(OrderProduct orderProduct, Long id);
    public void deleteOrderProduct(Long id);
    public OrderProduct addOrderProduct(OrderProduct orderProduct);
    public OrderProduct getOrderProductById(Long id);
    public List<OrderProduct> OrderbyUser(long idUser);
}
