package ru.netology.book;

import ru.netolog.product.Product;

public class Book extends Product {
    private String author;

public Book(){
    super();

}
    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }


    public String getAuthor() {
        return author;
    }


}
