package com.vapeordie.vapeordie.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.vapeordie.vapeordie.dto.OrderProductDto;
import com.vapeordie.vapeordie.dto.ProductQteDto;
import com.vapeordie.vapeordie.model.OrderLine;
import com.vapeordie.vapeordie.model.OrderProduct;
import com.vapeordie.vapeordie.model.Product;
import com.vapeordie.vapeordie.repository.OrderLineRepository;
import com.vapeordie.vapeordie.service.NotificationService;
import com.vapeordie.vapeordie.service.OrderProduct.OrderProductService;
import com.vapeordie.vapeordie.service.Product.ProductService;
import com.vapeordie.vapeordie.service.User.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/rest")


public class OrderProductRestController {

    private Logger logger = LoggerFactory.getLogger(OrderProductRestController.class);
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Autowired
    private OrderProductService orderProductService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Autowired
    private OrderLineRepository orderLineService;

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/orderProducts")
    public HttpStatus addOrderProduct(@RequestBody String orderProductObject) throws JsonProcessingException {
        OrderProductDto orderDto = new ObjectMapper().setDateFormat(simpleDateFormat).readValue(orderProductObject, OrderProductDto.class);
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setStatus("en attente de confirmartion");
        orderProduct.setOrderDate(new Date());
        orderProduct.setUser(userService.getUserById(orderDto.userId));
        orderProduct = orderProductService.addOrderProduct(orderProduct);
        double price = 0;
        int productAdded = 0;
        for (ProductQteDto product : orderDto.products) {
            if (!checkProductQte(product.getId(), product.getQte()))
                continue;
            OrderLine newOrderLine = new OrderLine();
            Product productToSet = productService.getProductById(product.getId());
            newOrderLine.setProduct(productToSet);
            price = productToSet.getPrice() * product.getQte();
            newOrderLine.setPrice(price);
            newOrderLine.setQuantity(product.getQte());
            newOrderLine.setOrderProduct(orderProduct);
            orderLineService.saveAndFlush(newOrderLine);
            setQte(product.getId(), product.getQte());
            productAdded++;
        }
        if (productAdded == 0) {
            orderProductService.deleteOrderProduct(orderProduct.getIdOrder());
            return HttpStatus.NOT_ACCEPTABLE;
        } else {
            // send notification
                try{
                    notificationService.sendNotification(userService.getUserById(orderDto.userId),orderProduct);
                }catch (MailException ex){
                    logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! Erreur email: "+ex.getMessage());
                }
            //return confirmation
            return HttpStatus.ACCEPTED;
        }

    }

    public boolean checkProductQte(long productId, int qte) {
        return (productService.getProductById(productId).getQuantity() >= qte) ? true : false;
    }

    public void setQte(long productId, int qte) {
        Product product = productService.getProductById(productId);
        System.out.println("old qte : " + product.getQuantity() + " new qte : " + (product.getQuantity() - qte));
        product.setQuantity(product.getQuantity() - qte);
        productService.updateProduct(product, product.getIdProduct(), product.getCategory().getIdCategory());
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
    @GetMapping("/ordersByUser/{idUser}")
    public List<OrderProduct> ordersByUser(@PathVariable("idUser") Long idUser) {
        return orderProductService.OrderbyUser(idUser);
    }
}