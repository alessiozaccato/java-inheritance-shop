package com.lesson.java.shop;

import java.math.BigDecimal;

public class Televisore extends Prodotto{

    private float sizes;
    private boolean isSmart;
    
    public Televisore(String name, String brand, BigDecimal price, float iva, float sizes, boolean isSmart) {
        super(name, brand, price, iva);
        this.sizes=sizes;
        this.isSmart=isSmart;
    }

    public String isSmaString() {
        if (isSmart) {
            return "è una smart tv";
        } else {
            return "non è una smart tv";
        }
    }

    public float getSizes() {
        return this.sizes;
    }

    public void setSizes(float sizes) {
        this.sizes=sizes;
    }

    public boolean getIsSmart() {
        return this.isSmart;
    }

    public void setIsSmart(boolean isSmart) {
        this.isSmart =isSmart;
    }
 



    @Override
    public String toString() {
        
        return super.toString() + String.format("la dimensione della tv è: %.2f, %s", this.sizes, this.isSmaString());
    }
    


}
