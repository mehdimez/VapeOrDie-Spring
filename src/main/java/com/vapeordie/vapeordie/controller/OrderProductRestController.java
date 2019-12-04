package com.vapeordie.vapeordie.controller;


import com.vapeordie.vapeordie.model.OrderProduct;
import com.vapeordie.vapeordie.service.OrderProduct.OrderProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class OrderProductRestController {

    private final OrderProductService orderProductService;

    public OrderProductRestController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }

    @PostMapping("/OrderProducts/")
    public OrderProduct addOrderProduct(@RequestBody OrderProduct orderProduct) { return orderProductService.addOrderProduct(orderProduct);}

    @GetMapping("/OrderProducts/")
    public List<OrderProduct> getAllOrderProduct() { return orderProductService.getAllOrderProduct();}

    @PutMapping("/OrderProducts/{id}")
    public OrderProduct updateOrderProduct(@RequestBody OrderProduct orderProduct, @PathVariable("id") Long id) {
        OrderProduct orderProduct1 = orderProductService.getOrderProductById(id);
        orderProduct1.setStatus(orderProduct.getStatus());
        return orderProductService.updateOrderProduct(orderProduct1,id);
    }
    @DeleteMapping("/OrderProducts/{id}")
    public void deleteOrderProduct(@PathVariable("id") Long id) { orderProductService.deleteOrderProduct(id);}


    @GetMapping("/orderProducts/{id}")
    public OrderProduct getOrderProductById(@PathVariable Long id) { return orderProductService.getOrderProductById(id);}
}
