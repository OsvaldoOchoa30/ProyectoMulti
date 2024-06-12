package org.marcosbrindis.proyectomultidiciplinario.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.UUID;

public class Pedido {

    //Atributos de Pedido
    private static int nextId = 1;
    private String idPedido;
    private double total;
    private LocalDate fecha;
    private LocalDateTime hora;
    private LinkedList<Producto> orden = new LinkedList<>();
    private Boolean status;

    //Metodo Constructor
    public Pedido(double total, LinkedList<Producto> orden) {
        this.idPedido = String.format("%04d", nextId++);
        this.total = total;
        this.fecha = LocalDate.now();
        this.hora = LocalDateTime.now();
        this.orden = orden;
        this.status = true;
    }

    public void agregarproductos(Producto producto) {
        orden.add(producto);
    }

    public void cancelar() {
        this.status = false;
    }

    public String generarResivo() {
        String imprimir = idPedido + "  " + fecha + "   " + hora + "\n";
        int i = 0;
        for (Producto producto : orden) {
            imprimir += i + ") " + producto.toString() + "\n";
            i++;
        }
        return imprimir;
    }

    //Getters y Setters

    public double getTotal() {
        return total;
    }

    public LinkedList<Producto> getOrden() {
        return orden;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public void setOrden(LinkedList<Producto> orden) {
        this.orden = orden;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    //Metodo To String
    @Override
    public String toString() {
        String productos = "";
        for (Producto producto : orden) {
            productos += producto.toString() + "\n";
        }
        return "Pedido{" +
                "idPedido='" + idPedido + '\'' +
                ", total=" + total +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", orden=\n" + productos +
                ", status=" + status +
                '}';
    }
}
