package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netolog.product.Product;
import ru.netology.book.Book;
import ru.netology.repository.Repository;
import ru.netology.manager.Manager;
import ru.netology.smartphone.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Repository repo = new Repository();
    Manager manager = new Manager(repo);
    private Product dress = new Product(1703, "Anna", 100);
    private Book one = new Book(0212, "Tima", 400, "Mizo");
    private Smartphone samsung = new Smartphone(2511, "Samsung 13", 120000, "USA");


    @Test
    void add3Product() {
        manager.add(dress);
        manager.add(one);
        manager.add(samsung);

        Product[] actual = repo.findAll();
        Product[] expected = {dress, one, samsung};

        assertArrayEquals(expected, actual);
    }

    @Test
    void add2Product() {
        manager.add(dress);
        manager.add(one);
        Product[] actual = repo.findAll();
        Product[] expected = {dress, one};
        assertArrayEquals(expected, actual);
    }

    @Test
    void addProduct() {
        manager.add(samsung);

        Product[] actual = repo.findAll();
        Product[] expected = {samsung};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBy3Product() {
        manager.add(dress);
        manager.add(one);
        manager.add(samsung);

        Product[] actual = manager.searchBy("Tima");
        Product[] expected = {one};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBy2Product() {
        manager.add(dress);
        manager.add(samsung);

        Product[] actual = manager.searchBy( "Samsung 13");
        Product[] expected = { samsung};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByProduct() {
        manager.add(dress);


        Product[] actual = manager.searchBy("Anna");
        Product[] expected = {dress};
        assertArrayEquals(expected, actual);


    }
    @Test
    void searchByProductWhenTwoItemsMatchTheRequest() {
        Smartphone iphone128Gb = new Smartphone(45, "Iphone12", 1000, "Apple");
        Smartphone iphone256Gb = new Smartphone(46, "Iphone12", 2000, "Apple");
        manager.add(dress);
        manager.add(one);
        manager.add(samsung);
        manager.add(iphone128Gb);
        manager.add(iphone256Gb);


        Product[] actual = manager.searchBy("Iphone12");
        Product[] expected = {iphone128Gb, iphone256Gb};

        assertArrayEquals(expected, actual);
}
    @Test
    void searchByProductWhichIsNotOnTheList() {
        manager.add(dress);
        manager.add(one);
        manager.add(samsung);


        Product[] actual = manager.searchBy("50 shades of grey");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }
}