package org.marcosbrindis.proyectomultidiciplinario.models;

import java.util.ArrayList;

public class Venta {
    private double granTotal;
    ArrayList<Pedido>salesList=new ArrayList<>();

    public Venta() {
        this.salesList = salesList;
    }

    public void agregarVenta(Pedido pedido) {
        salesList.add(pedido);
    }

    public double obtenerTotal(){
        granTotal = 0.0;
        for (Pedido pedido : salesList) {
            granTotal += pedido.getTotal();
        }
        return granTotal;
    }

}
