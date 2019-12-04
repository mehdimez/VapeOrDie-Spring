package com.vapeordie.vapeordie.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.vapeordie.vapeordie.dto.OrderProductDto;
import com.vapeordie.vapeordie.dto.ProductQteDto;
import com.vapeordie.vapeordie.model.OrderLine;
import com.vapeordie.vapeordie.model.OrderProduct;
import com.vapeordie.vapeordie.repository.OrderLineRepository;
import com.vapeordie.vapeordie.service.OrderProduct.OrderProductService;
import com.vapeordie.vapeordie.service.Product.ProductService;
import com.vapeordie.vapeordie.service.User.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rest")


public class OrderProductRestController {


    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private OrderProductService orderProductService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderLineRepository orderLineService;

    @PostMapping("/orderProducts")
    public Object addOrderProduct(@RequestBody String orderProductObject) throws JsonProcessingException {
        OrderProductDto orderDto = new ObjectMapper().setDateFormat(simpleDateFormat).readValue(orderProductObject, OrderProductDto.class);
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setStatus(orderDto.status);
        orderProduct.setOrderDate(orderDto.date);
        orderProduct.setUser(userService.getUserById(orderDto.userId));
        orderProduct = orderProductService.addOrderProduct(orderProduct);
        for (ProductQteDto product : orderDto.products) {
            OrderLine newOrderLine = new OrderLine();
            newOrderLine.setProduct(productService.getProductById(product.getId()));
            newOrderLine.setQuantity(product.getQte());
            newOrderLine.setOrderProduct(orderProduct);
            orderLineService.saveAndFlush(newOrderLine);
        }
        return "done";
    }

    @GetMapping("/orderProducts")
    public List<OrderProduct> getAllOrderProduct() {
        return orderProductService.getAllOrderProduct();
    }

    @PutMapping("/orderProducts/{id}")
    public OrderProduct updateOrderProduct(@RequestBody OrderProduct orderProduct, @PathVariable("id") Long id) {
        OrderProduct orderProduct1 = orderProductService.getOrderProductById(id);
        orderProduct1.setStatus(orderProduct.getStatus());
        return orderProductService.updateOrderProduct(orderProduct1, id);
    }

    @DeleteMapping("/orderProducts/{id}")
    public void deleteOrderProduct(@PathVariable("id") Long id) {
        orderProductService.deleteOrderProduct(id);
    }


    @GetMapping("/orderProducts/{id}")
    public OrderProduct getOrderProductById(@PathVariable Long id) {
        return orderProductService.getOrderProductById(id);
    }
}
