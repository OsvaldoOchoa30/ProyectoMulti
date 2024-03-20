package org.marcosbrindis.proyectomultidiciplinario.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Taqueria {
    private Queue<Pedido>orderList=new LinkedList<>();
    private ArrayList<Usuario>userList=new ArrayList<>();

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









}
