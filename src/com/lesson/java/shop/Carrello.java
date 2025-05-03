package com.lesson.java.shop;

import java.math.BigDecimal;
import java.util.Scanner;

public class Carrello {

    private Prodotto[] cart;

    public Carrello() {
        this.cart = new Prodotto[0];
    }

    public void addToCart(Prodotto newProdotto) {

        Prodotto[] updatedCart = new Prodotto[cart.length + 1];

        for (int i = 0; i < cart.length; i++) {
            updatedCart[i] = cart[i];
        }

        updatedCart[updatedCart.length - 1] = newProdotto;

        cart = updatedCart;
    }

    public void showCart() {

        for (int i = 0; i < cart.length; i++) {
            System.out.println(cart[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Smartphone smart1 = new Smartphone("g7", "lg", new BigDecimal(200.5), 0, 123, 512);
        Televisore tv1 = new Televisore("beltv", "lg", new BigDecimal(400.5), 0, 40, false);
        Prodotto cuffia1 = new Cuffie("bellacuffia", "lg", new BigDecimal(40.5), 0, "rosso", false);

        Carrello cart = new Carrello();

        boolean isStart = true;

        while (isStart) {

            System.out.println("Cosa vuoi fare?");
            System.out.println("1 - Aggiungi Smartphone");
            System.out.println("2 - Aggiungi Televisore (non ancora implementato)");
            System.out.println("3 - Aggiungi Cuffie (non ancora implementato)");
            System.out.println("4 - Visualizza Carrello");
            System.out.println("5 - Esci");
            System.out.print("Inserisci la tua scelta: ");
            String chosenCase = sc.nextLine();

            switch (chosenCase.toLowerCase()) {
                case "1":
                    System.out.println("inserisci il nome dello smartphone");
                    String nameSm = sc.nextLine();
                    System.out.println("inserisci il brand prodotto");
                    String brandSm = sc.nextLine();
                    System.out.println("inserisci il prezzo prodotto");
                    BigDecimal priceSm = new BigDecimal(sc.nextLine());
                    System.out.println("inserisci l'iva prodotto");
                    float ivaSm = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("inserisci imei prodotto");
                    int imeiCodeSm = sc.nextInt();
                    System.out.println("inserisci memoria prodotto");
                    int memorySm = sc.nextInt();
                    sc.nextLine();
                    cart.addToCart(new Smartphone(nameSm, brandSm, priceSm, ivaSm / 100, imeiCodeSm, memorySm));

                    break;
                case "2":
                    System.out.println("Funzionalità per l'aggiunta di televisori non ancora implementata.");
                    break;
                case "3":
                    System.out.println("Funzionalità per l'aggiunta di cuffie non ancora implementata.");
                    break;
                case "4":
                    cart.showCart();
                    break;
                case "5":
                    isStart = false;
                    System.out.println("Grazie per il tuo acquisto!");
                    break;
                default:
                    System.out.println("Scelta non valida.");
            }
        }

    }
}
