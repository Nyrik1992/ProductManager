package ru.netology.smartphone;

import ru.netolog.product.Product;

public class Smartphone extends Product {
    private String manufacturer;

public  Smartphone(){
}

    public Smartphone(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }
}