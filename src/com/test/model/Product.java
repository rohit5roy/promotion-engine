package com.test.model;

public class Product {
    private String id;
    private int price;

    public Product(String id)
    {
        this.id = id;
        switch (id)
        {
            case "A":
                this.price = 50;

                break;
            case "B":
                this.price = 30;

                break;
            case "C":
                this.price = 20;

                break;
            case "D":
                this.price = 15;
                break;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

