package com.xebia.shop.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class ShoppingCart {
    private Date created;
    @OneToMany(mappedBy = "shoppingCart", targetEntity = LineItem.class)
    @JsonManagedReference
    private List<LineItem> lineItems = new ArrayList<LineItem>();
    @Id
    private UUID uuid;

    public ShoppingCart() {
    }

    public ShoppingCart(Date created, UUID uuid) {
        this.uuid = uuid;
        this.created = created;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> newItems) { lineItems = newItems; }
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void removeItem(int itemNumber) {
        lineItems.remove(itemNumber);
    }

    public void addLineItem(LineItem lineItem) {
        lineItem.setShoppingCart(this);
        lineItems.add(lineItem);
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public double calcTotal() {
        double total = 0;
        for (LineItem lineItem: lineItems) {
            total += lineItem.getPrice();
        }
        return total;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private double total;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingCart that = (ShoppingCart) o;

        return uuid.equals(that.uuid);

    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "created=" + created +
//                ", lineItems=" + lineItems.size() +
                ", uuid=" + uuid +
                '}';
    }
}
