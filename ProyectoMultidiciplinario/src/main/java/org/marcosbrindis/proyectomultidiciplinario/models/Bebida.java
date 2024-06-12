//Clase Hija con los atributos de Producto.
package org.marcosbrindis.proyectomultidiciplinario.models;

public class Bebida extends Producto {
    //Se agrega los nuevos atributos de la clase hija Producto.
    protected String typeDrink;
    protected String sizeDrink;

    //Creamos el metodo constructor de la clase bebida con los atributos respectivos y los heredados.
    public Bebida(String productName, String productDescription, Double productPrice, int quantity, String typeDrink, String sizeDrink) {
        super(productName, productDescription, productPrice, quantity);
        this.typeDrink = typeDrink;
        this.sizeDrink = sizeDrink;
    }


    //Getters y Setter de la clase Bebida.
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
