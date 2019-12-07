package com.vapeordie.vapeordie.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class OrderProductDto
{

    public long userId ;
    public String status;
    @JsonFormat(pattern = "dd/MM/yyyy")
    // Allows dd/MM/yyyy date to be passed into GET request in JSON
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    public Date date;
    public List<ProductQteDto> products;


    public OrderProductDto(){}
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ProductQteDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductQteDto> products) {
        this.products = products;
    }

    public OrderProductDto(long userId, String status, Date date, List<ProductQteDto> products) {
        this.userId = userId;
        this.status = status;
        this.date = date;
        this.products = products;
    }
}