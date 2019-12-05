package com.vapeordie.vapeordie.dto;

public class ProductQteDto {

    private long id;
    private int qte;

    public  ProductQteDto()
    {

    }
    public ProductQteDto(long id, int qte) {
        this.id = id;
        this.qte = qte;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
}
