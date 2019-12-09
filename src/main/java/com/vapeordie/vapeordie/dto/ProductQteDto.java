package com.vapeordie.vapeordie.dto;

public class ProductQteDto {

    private long id;
    private int qteProduct;

    public  ProductQteDto()
    {

    }
    public ProductQteDto(long id, int qteProduct) {
        this.id = id;
        this.qteProduct = qteProduct;
    }

    public long getId() {
        return id;
    }

    public void setId(long idProduct) {
        this.id = idProduct;
    }

    public int getQte() {
        return qteProduct;
    }

    public void setQte(int qteProduct) {
        this.qteProduct = qteProduct;
    }
}
