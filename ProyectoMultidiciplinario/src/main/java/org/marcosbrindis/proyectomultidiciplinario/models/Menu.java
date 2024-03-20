package org.marcosbrindis.proyectomultidiciplinario.models;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Producto> menu = new ArrayList<>();

    public void addProduct(Producto producto) {
        menu.add(producto);
    }

    public void removeProduct(Producto producto) {
        menu.remove(producto);
    }

    public void modifyProduct(String productId, String nuevoNombre, String nuevaDescripcion, double nuevoPrecio, String nuevoTipoCarne, String nuevoTipoBebida, String nuevoTamBebida) {
        for (Producto actual : menu) {
            if (actual.getProductId().equals(productId)) {
                actual.setProductName(nuevoNombre);
                actual.setProductDescription(nuevaDescripcion);
                actual.setProductPrice(nuevoPrecio);
            }
            if (actual instanceof Taco) {
                ((Taco) actual).setTypeMeat(nuevoTipoCarne);
            }
            if (actual instanceof Bebida){
                ((Bebida) actual).setTypeDrink(nuevoTipoBebida);
                ((Bebida) actual).setSizeDrink(nuevoTamBebida);
            }
        }
    }

}