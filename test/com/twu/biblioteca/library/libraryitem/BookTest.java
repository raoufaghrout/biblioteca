package com.twu.biblioteca.library.libraryitem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest extends LibraryItemTest {

    @Test
    public void testToStringWhenUserIsNull() {
        assertEquals("1 | To Kill a MockingBird | Harper Lee | 1960", bookWithNoUser.toString().trim());
    }

    @Test
    public void testToStringWhenUserIsNotNull() {
        assertEquals("1 | To Kill a MockingBird | Harper Lee | 1960 | Test User", bookWithUser.toString().trim());
    }
}
