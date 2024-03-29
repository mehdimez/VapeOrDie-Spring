package com.vapeordie.vapeordie.model;

import javax.persistence.*;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "idOrder")
    private OrderProduct orderProduct;
    private int quantity;
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(OrderProduct orderProduct) {
        this.orderProduct = orderProduct;
    }
}