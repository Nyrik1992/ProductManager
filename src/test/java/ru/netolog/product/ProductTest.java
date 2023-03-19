package ru.netolog.product;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product = new Product(232, "Oly", 300);


    @Test
    void testSetName() {
        String expected = "Why";
        product.setName(expected);
        String actual = product.getName();
        assertEquals(expected, actual);

        System.out.println("Новое имя " + actual);
    }

    @Test
    void testSetNameNull() {
        String expected = null;
        product.setName(expected);
        String actual = product.getName();
        assertEquals(expected, actual);

        System.out.println("Новое имя " + actual);
    }
}