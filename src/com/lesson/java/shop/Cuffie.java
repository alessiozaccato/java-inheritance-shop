package com.lesson.java.shop;

import java.math.BigDecimal;

public class Cuffie extends Prodotto {

    private String color;
    private boolean isWired;

    

    public Cuffie(String name, String brand, BigDecimal price, float iva, String color, boolean isWired) {
        super(name, brand, price, iva);
        this.color = color;
        this.isWired = isWired;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isIsWired() {
        return this.isWired;
    }

    public void setIsWired(boolean isWired) {
        this.isWired = isWired;
    }

    public String isWiredString() {
        if (isWired) {
            return "è cablato";
        } else {
            return "è wireless";
        }
    }

    @Override
    public String toString() {
        
        return super.toString() + String.format(", color: %s, %s", this.color, this.isWiredString());
    }
}
