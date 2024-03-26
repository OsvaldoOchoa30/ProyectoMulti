package org.marcosbrindis.proyectomultidiciplinario.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.UUID;

public class Pedido {
    private String idPedido= String.valueOf(UUID.randomUUID());
    private double total;
    private LocalDate fecha;
    private LocalDateTime hora;

    private LinkedList<Producto>orden= new LinkedList<>();

    private boolean status;

    public void cancelar(){
        this.status=false;
    }

    public String generarResivo(){
        String imprimir=idPedido+"  "+fecha+"   "+hora+"\n";
        int i=0;
        for (Producto producto : orden){
            imprimir += i + ") " + producto.toString() + "\n";
            i++;
        }
        return imprimir;
    }

    public double getTotal() {
        return total;
    }
}
