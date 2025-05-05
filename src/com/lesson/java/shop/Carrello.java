package com.lesson.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public String discountedPrice(Prodotto prodotto, boolean hasFidelityCard) {

        BigDecimal discountedPriceWithIva = prodotto.salePrice(hasFidelityCard)
                .multiply(BigDecimal.ONE.add(new BigDecimal(prodotto.getIva())))
                .setScale(2, RoundingMode.HALF_UP);

        String formattedDiscountedPrice = discountedPriceWithIva.toPlainString();
        String description = prodotto.toString();
        return description += String.format(" | Prezzo con IVA (base): %s ", formattedDiscountedPrice);

    }

    public void getCartProducts(boolean hasFidelityCard) {

        BigDecimal somma = new BigDecimal(0);

        BigDecimal sommaNoDiscounted = new BigDecimal(0);

        for (Prodotto prodotto : cart) {

            sommaNoDiscounted = sommaNoDiscounted.add(prodotto.getPrice());

            somma = somma.add(prodotto.salePrice(hasFidelityCard));

            System.out.println(this.discountedPrice(prodotto, hasFidelityCard));

        }

        System.out.println("totale carrello scontato: " + sommaNoDiscounted + " somma carrello con prezzo base: " + somma.setScale(2,RoundingMode.HALF_UP));

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Carrello cart = new Carrello();

        boolean isStart = true;

        System.out.println("hai la tessera fedelta' (si o no)");
        String fideltyStringInput = sc.nextLine();
        boolean isFidelityCard = false;
        if (fideltyStringInput.equals("si")) {
            isFidelityCard = true;
        } else if (fideltyStringInput.equals("no")) {
            isFidelityCard = false;
        }

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
                    boolean isSmartTv = false;
                    if (isSmartTvInput.equals("si")) {
                        isSmartTv = true;
                    } else if (isSmartTvInput.equals("no")) {
                        isSmartTv = false;
                    }

                    // boolean isSmartTv = isSmartTvInput.equalsIgnoreCase("si");
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
                    boolean isWiredHp = false;
                    if (isWiredHpInput.equals("si")) {
                        isWiredHp = true;
                    } else if (isWiredHpInput.equals("no")) {
                        isWiredHp = false;
                    }
                    // alternate method with equalsIgnoreCase
                    // boolean isWiredHp = isWiredHpInput.equalsIgnoreCase("si");
                    cart.addToCart(new Cuffie(nameHp, brandHp, priceHp, ivaHp / 100, colorHp, isWiredHp));
                    break;
                case "4":
                    cart.getCartProducts(isFidelityCard);
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
