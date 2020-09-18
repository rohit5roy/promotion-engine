package com.promotion.model;

import java.util.List;

public class Order {

    private int orderId;
    private List<Product> products;

    public Order(int oId, List<Product> prods)
    {
        this.orderId = oId;
        this.products = prods;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
