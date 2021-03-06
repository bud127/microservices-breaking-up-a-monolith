package com.xebia.msa.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class LineItem {
    @Id
    private UUID uuid;
    private int quantity;
    @ManyToOne(fetch= FetchType.LAZY)
    @JsonBackReference
    private ShoppingCart shoppingCart;
    @OneToOne(optional = false)
    private Product product;
    private double price;

    public LineItem() {}

    public LineItem(UUID uuid, int quantity, double price, Product product) {
        this.uuid = uuid;
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public LineItem(int quantity, double price, Product product) {
        this.uuid = UUID.randomUUID();
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "quantity=" + quantity +
                ", shoppingCartId=" + shoppingCart.getUuid() +
            //    ", order=" + order +
                ", product=" + product +
                ", price=" + price +
                '}';
    }
}
