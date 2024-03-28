package org.marcosbrindis.proyectomultidiciplinario.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Taqueria {
    private Queue<Pedido>orderList;
    private ArrayList<Usuario>userList=new ArrayList<>();
    private ArrayList<Producto> menu = new ArrayList<>();
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


    public Queue<Pedido> getOrderList() {
        return orderList;
    }

    public ArrayList<Usuario> getUserList() {
        return userList;
    }

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

    public String viewProduct(Producto producto){
        String view= "ID: " + producto.getProductId() + "\n"
                + "Nombre: " + producto.getProductName() + "\n"
                + "Descripción: " + producto.getProductDescription() + "\n"
                + "Precio: " + producto.getProductPrice() + "\n"
                + "Cantidad: " + producto.getQuantity() + "\n";

        if (producto instanceof Taco) {
            Taco taco = (Taco) producto;
            view += "Tipo de carne: " + taco.getTypeMeat() + "\n";
        } else if (producto instanceof Bebida) {
            Bebida bebida = (Bebida) producto;
            view += "Tipo de bebida: " + bebida.getTypeDrink() + "\n"
                    + "Tamaño de bebida: " + bebida.getSizeDrink() + "\n";
        }
        return view;
    }

    public ArrayList<Producto> getMenu() {
        return menu;
    }
}
