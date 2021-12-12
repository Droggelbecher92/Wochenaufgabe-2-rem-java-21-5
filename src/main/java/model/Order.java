package model;

import java.util.HashMap;
import java.util.Objects;

public class Order {

    private String id;
    private HashMap<String,Product> orderedProducts;

    public Order(String id, HashMap<String, Product> orderedProducts) {
        this.id = id;
        this.orderedProducts = orderedProducts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<String, Product> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(HashMap<String, Product> orderedProducts) {
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
