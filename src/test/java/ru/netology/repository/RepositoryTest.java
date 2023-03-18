package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netolog.product.Product;
import ru.netology.book.Book;
import ru.netology.smartphone.Smartphone;

import java.nio.file.attribute.UserDefinedFileAttributeView;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    private Repository repo = new Repository();
    private Product dress = new Product(1703, "Anna", 100);
    private Book one = new Book(0212, "Tima", 400, "Mizo");
    private Smartphone samsung = new Smartphone(2511, "Samsung 13", 120000, "USA");


    @Test
    void saveThreeProduct() {
        repo.save(dress);
        repo.save(one);
        repo.save(samsung);

        Product[] actual = repo.findAll();
        Product[] expected = {dress, one, samsung};
        assertArrayEquals(actual, expected);

    }

    @Test
    void saveTwoProduct() {
        repo.save(one);
        repo.save(samsung);

        Product[] actual = repo.findAll();
        Product[] expected = {one, samsung};
        assertArrayEquals(actual, expected);
    }

    @Test
    void saveOneProduct() {
        repo.save(one);

        Product[] actual = repo.findAll();
        Product[] expected = {one};
        assertArrayEquals(actual, expected);
    }

    @Test
    void findAll() {
        Product[] actual = repo.findAll();
        Product[] expected = {};
        assertArrayEquals(actual, expected);
    }

    @Test
    void removeById() {
        repo.save(dress);
        repo.save(one);
        repo.save(samsung);

        repo.removeById(2511);

        Product[] actual = repo.findAll();
        Product[] expected = {dress,one};

        assertArrayEquals( actual, expected);
    }
    @Test
    void removeTwoById() {
        repo.save(dress);
        repo.save(one);
        repo.save(samsung);

        repo.removeById(2511);
        repo.removeById(1703);

        Product[] actual = repo.findAll();
        Product[] expected = {one};

        assertArrayEquals( actual, expected);
    }
    @Test
    void removeAllById() {
        repo.save(dress);
        repo.save(one);
        repo.save(samsung);

        repo.removeById(2511);
        repo.removeById(1703);
        repo.removeById(0212);

        Product[] actual = repo.findAll();
        Product[] expected = {};

        assertArrayEquals( actual, expected);
    }
}