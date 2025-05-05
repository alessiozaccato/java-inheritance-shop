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

        Carrello cart = new Carrello();

        boolean isStart = true;

        while (isStart) {

            System.out.println("Cosa vuoi fare?");
            System.out.println("1 - Aggiungi Smartphone");
            System.out.println("2 - Aggiungi Televisore");
            System.out.println("3 - Aggiungi Cuffie");
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
                    System.out.println("inserisci il nome del televisore");
                    String nameTv = sc.nextLine();
                    System.out.println("inserisci il brand televisore");
                    String brandTv = sc.nextLine();
                    System.out.println("inserisci il prezzo della tv");
                    BigDecimal priceTv = new BigDecimal(sc.nextLine());
                    System.out.println("inserisci l'iva prodotto");
                    float ivaTv = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("inserisci grandezza prodotto");
                    int sizesTv = sc.nextInt();
                    sc.nextLine();
                    System.out.println("la tv è smart? (si o no)");
                    String isSmartTvInput = sc.nextLine();
                    boolean isSmartTv = isSmartTvInput.equalsIgnoreCase("si");
                    cart.addToCart(new Televisore(nameTv, brandTv, priceTv, ivaTv / 100, sizesTv, isSmartTv));

                    break;
                case "3":
                    System.out.println("inserisci il nome delle cuffie");
                    String nameHp = sc.nextLine();
                    System.out.println("inserisci il brand delle cuffie");
                    String brandHp = sc.nextLine();
                    System.out.println("inserisci il prezzo dellle cuffie");
                    BigDecimal priceHp = new BigDecimal(sc.nextLine());
                    System.out.println("inserisci l'iva prodotto");
                    float ivaHp = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("inserisci colore delle cuffie");
                    String colorHp = sc.nextLine();
                    System.out.println("le cuffie sono cablate? (si o no)");
                    String isWiredHpInput = sc.nextLine();
                    boolean isWiredHp = isWiredHpInput.equalsIgnoreCase("si");
                    cart.addToCart(new Cuffie(nameHp, brandHp, priceHp, ivaHp / 100, colorHp, isWiredHp));
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
        sc.close();
    }
}
