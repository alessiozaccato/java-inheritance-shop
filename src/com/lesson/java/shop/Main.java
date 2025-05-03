package com.lesson.java.shop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Prodotto prodotto1 = new Prodotto("pr1", "sams", new BigDecimal(300.5), 0);
        Smartphone smart1 = new Smartphone("g7", "lg", new BigDecimal(200.5), 0, 123, 512);
        Televisore tv1 = new Televisore("beltv", "lg", new BigDecimal(400.5), 0, 40, false);
        Prodotto cuffia1 = new Cuffie("bellacuffia", "lg", new BigDecimal(40.5), 0, "rosso", false); 

        System.out.println(prodotto1);
        System.out.println(smart1);
        System.out.println(tv1);
        System.out.println(cuffia1);


    }
}
