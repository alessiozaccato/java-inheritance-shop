package com.lesson.java.shop;

import java.math.BigDecimal;

public class Smartphone extends Prodotto {

    private int imeiCode;
    private int memory;

    public Smartphone(String name, String brand, BigDecimal price, float iva, int imeiCode, int memory) {
        super(name, brand, price, iva);
        this.imeiCode = imeiCode;
        this.memory = memory;
    }

    public int getImeiCode() {
        return this.imeiCode;
    }

    public void setImeiCode(int imeiCode) {
        this.imeiCode=imeiCode;
    }

    public int getMemory() {
        return this.memory;
    }

    public void setMemory(int memory) {
        this.memory =memory;
    }


    @Override
    public String toString() {

        return super.toString() + String.format(", imeiCode : %d, memoria: %d", imeiCode, memory);
    }

}
