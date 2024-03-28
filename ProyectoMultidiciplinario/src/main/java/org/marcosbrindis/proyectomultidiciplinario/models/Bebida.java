package org.marcosbrindis.proyectomultidiciplinario.models;

public class Bebida extends Producto {
    protected String typeDrink;
    protected String sizeDrink;

    public Bebida(String productName, String productDescription, Double productPrice, int quantity, String typeDrink, String sizeDrink) {
        super(productName, productDescription, productPrice, quantity);
        this.typeDrink = typeDrink;
        this.sizeDrink = sizeDrink;
    }

    public String getTypeDrink() {
        return typeDrink;
    }

    public void setTypeDrink(String typeDrink) {
        this.typeDrink = typeDrink;
    }

    public String getSizeDrink() {
        return sizeDrink;
    }

    public void setSizeDrink(String sizeDrink) {
        this.sizeDrink = sizeDrink;
    }
}
