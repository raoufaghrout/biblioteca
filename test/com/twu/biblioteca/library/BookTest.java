package com.twu.biblioteca.library;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest extends LibraryItemTest {

    @Test
    public void testToString() {
        assertEquals("1 | To Kill a MockingBird | Harper Lee | 1960", book.toString().trim());
    }
}
