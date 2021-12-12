package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Order {

    private String id;
    private ArrayList<String> orderedProducts;

    public Order(String id, ArrayList<String> orderedProducts) {
        this.id = id;
        this.orderedProducts = orderedProducts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(ArrayList<String> producIds) {
        this.orderedProducts = orderedProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(orderedProducts, order.orderedProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderedProducts);
    }

    @Override
    public String toString() {
        return "Bestellung Nr:"+ id + " bestellte Produkte =" + orderedProducts;
    }
}
