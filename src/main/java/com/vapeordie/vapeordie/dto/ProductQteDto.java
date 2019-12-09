package com.vapeordie.vapeordie.dto;

public class ProductQteDto {

    private long idProduct;
    private int qteProduct;

    public  ProductQteDto()
    {

    }
    public ProductQteDto(long idProduct, int qteProduct) {
        this.idProduct = idProduct;
        this.qteProduct = qteProduct;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public int getQteProduct() {
        return qteProduct;
    }

    public void setQteProduct(int qteProduct) {
        this.qteProduct = qteProduct;
    }
}
