package org.marcosbrindis.proyectomultidiciplinario.models;

import java.util.Objects;

public class Usuario {
    private String nameUser;
    private String password;
    private String rolUser;

    public Usuario(String nameUser, String password, String rolUser) {
        this.nameUser = nameUser;
        this.password = password;
        this.rolUser = rolUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRolUser() {
        return rolUser;
    }

    public void setRolUser(String rolUser) {
        this.rolUser = rolUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nameUser, usuario.nameUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameUser);
    }
}
