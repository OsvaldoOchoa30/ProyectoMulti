package org.marcosbrindis.proyectomultidiciplinario.models;

public class Taco extends Producto{
    protected String typeMeat;

    public Taco(String productName, String productDescription, Double productPrice, int quantity, String typeMeat) {
        super(productName, productDescription, productPrice, quantity);
        this.typeMeat = typeMeat;
    }

    public String getTypeMeat() {
        return typeMeat;
    }

    public void setTypeMeat(String typeMeat) {
        this.typeMeat = typeMeat;
    }
}
