package com.vapeordie.vapeordie.service.OrderProduct;

import com.vapeordie.vapeordie.model.OrderProduct;
import com.vapeordie.vapeordie.repository.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;

    @Override
    public List<OrderProduct> getAllOrderProduct() {
        return orderProductRepository.findAll();
    }

    @Override
    public OrderProduct updateOrderProduct(OrderProduct orderProduct, Long id) {
        OrderProduct orderProduct1 = orderProductRepository.findById(id).get();
        orderProduct1.setStatus(orderProduct.getStatus());
        return orderProductRepository.saveAndFlush(orderProduct1);
    }

    @Override
    public void deleteOrderProduct(Long id) {
        orderProductRepository.deleteById(id);
    }

    @Override
    public OrderProduct addOrderProduct(OrderProduct orderProduct) {
        return orderProductRepository.saveAndFlush(orderProduct);
    }

    @Override
    public OrderProduct getOrderProductById(Long id) {
        return orderProductRepository.findById(id).get();
    }

    @Override
    public List<OrderProduct> OrderbyUser(long idUser) {
        return orderProductRepository.findByUser(idUser);
    }
}
