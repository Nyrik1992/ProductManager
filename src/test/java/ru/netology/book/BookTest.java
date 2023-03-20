package ru.netology.book;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book(0212, "Tima", 400, "Mizo");

    @Test
    void testGetAuthor(){
        String expected = "Mizo";
        String actual = book.getAuthor();

        assertEquals(expected,actual);
        System.out.println("Автор " + actual);

    }
    @Test
    void  testGetAuthorNull(){
        Book book = new Book();
        assertNotNull(book);
    }
    }