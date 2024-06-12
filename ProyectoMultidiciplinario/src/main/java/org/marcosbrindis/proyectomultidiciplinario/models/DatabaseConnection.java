package org.marcosbrindis.proyectomultidiciplinario.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/integrador";
    private static final String USER = "root";
    private static final String PASSWORD = "OsvaOK30";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void createUser(String name, String password, String rol) throws SQLException {
        String query = "INSERT INTO user (name_user, password_user, rol_user, created_at, created_by, updated_at, updated_by, deleted) VALUES (?, ?, ?, NOW(), ?, NOW(), ?, false)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, password);
            statement.setString(3, rol);
            statement.setString(4, name); // Asumiendo que el usuario se crea a sí mismo
            statement.setString(5, name);
            statement.executeUpdate();
        }
    }

    public static void updateUserPassword(String username, String newPassword) throws SQLException {
        String query = "UPDATE user SET password_user = ?, updated_at = NOW() WHERE name_user = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newPassword);
            statement.setString(2, username);
            statement.executeUpdate();
        }
    }

    public static Usuario getUser(String username) throws SQLException {
        String query = "SELECT * FROM user WHERE name_user = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nameUser = resultSet.getString("name_user");
                    String password = resultSet.getString("password_user");
                    String rolUser = resultSet.getString("rol_user");
                    System.out.println("Usuario encontrado en la base de datos: " + nameUser);
                    return new Usuario(nameUser, password, rolUser);
                } else {
                    System.out.println("Usuario no encontrado en la base de datos: " + username);
                    return null; // Usuario no encontrado.
                }
            }
        }
    }

    public static List<Usuario> getAllUsers() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT name_user, password_user, rol_user FROM user";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String name = resultSet.getString("name_user");
                String password = resultSet.getString("password_user");
                String rol = resultSet.getString("rol_user");
                usuarios.add(new Usuario(name, password, rol));
            }
        }
        return usuarios;
    }

    public static void deleteUser(String username) throws SQLException {
        String query = "DELETE FROM user WHERE name_user = ?";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.executeUpdate();
        }
    }
}