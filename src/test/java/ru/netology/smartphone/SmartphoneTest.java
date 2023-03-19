package ru.netology.smartphone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    private Smartphone samsung = new Smartphone(2511, "Samsung 13", 120000, "USA");

    @Test
    void testGetManufacturer() {

        String expected = "USA";
        String actual = samsung.getManufacturer();

        assertEquals(expected, actual);
        System.out.println("Производитель " + actual);
    }

    @Test
    void testEmptyConstructor() {
        Smartphone samsung = new Smartphone();
        assertNull(samsung.getManufacturer());
    }
}

