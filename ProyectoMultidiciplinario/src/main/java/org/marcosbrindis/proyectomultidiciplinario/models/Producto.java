package org.marcosbrindis.proyectomultidiciplinario.models;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Producto {
    private String productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private int quantity;

    public Producto(String productName, String productDescription, Double productPrice, int quantity) {
        this.productId = idcreate(productName);
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    public String idcreate(String productName) {
        String prefijo = productName.substring(0, Math.min(productName.length(), 3)).toUpperCase();
        Set<Integer> generated = new HashSet<>();
        Random random = new Random();
        while (generated.size() < 3) {
            int digit = random.nextInt(10);
            generated.add(digit);
        }
        StringBuilder id = new StringBuilder(prefijo);
        for (int digit : generated) {
            id.append(digit);
        }
        return id.toString();
    }

   /* @Override
    public String toString() {
        return "Producto{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", quantity=" + quantity +
                '}';
    }*/

    @Override
    public String toString() {
        return "Producto{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", quantity=" + quantity +
                '}';
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
