package com.lesson.java.shop;

import java.math.BigDecimal;
import java.util.Random;

public class Prodotto {

    Random rand = new Random();

    private int code;
    private String name;
    private String brand;
    private BigDecimal price;
    private float iva;
    

    public Prodotto(String name, String brand, BigDecimal price, float iva) {

        this.code = rand.nextInt(999999);
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.iva = iva;
        if (this.iva <= 0.22) {
            this.iva = 0.22f;
        }

    }

    // read only attribute
    public int getCode() {
        return this.code;
    }

    private void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public float getIva() {
        return this.iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    

    public BigDecimal salePrice (boolean fideltyCard) {
        if(fideltyCard) {
            return this.price.multiply(new BigDecimal(0.98));
        } 
        return this.price;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s, Marca: %s, Prezzo: %.2f, IVA: %.2f%%, Codice: %04d",
                this.name, this.brand, this.price, this.iva * 100, this.code);
    }

}
