package org.marcosbrindis.proyectomultidiciplinario.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Taqueria {
    private Queue<Pedido>orderList;
    private ArrayList<Usuario>userList=new ArrayList<>();
    private Venta venta;

    public Taqueria() {
        orderList = new LinkedList<>();
        venta = new Venta();
    }

    public void agregarPedido(Pedido pedido) {
        orderList.add(pedido);
    }

    public void transferirPedidosAVentas() {
        while (!orderList.isEmpty()) {
            Pedido pedido = orderList.poll();
            venta.agregarVenta(pedido);
        }
    }

    public void addUser(Usuario usuario){
        userList.add(usuario);
    }

    public void removeUser(Usuario usuario){
        userList.remove(usuario);
    }

    public void modifyUser(String password){
        for (Usuario actual:userList){
            actual.setPassword(password);
        }
    }

    public Queue<Pedido> getOrderList() {
        return orderList;
    }

    public ArrayList<Usuario> getUserList() {
        return userList;
    }
}
