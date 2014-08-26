package com.twu.biblioteca.library.libraryitem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest extends LibraryItemTest {

    @Test
    public void testToStringWhenUserIsNull() {
        assertEquals("3 | Pulp Fiction | Quentin Tarantino | 1994 | 10", movieWithNoUser.toString().trim());
    }

    @Test
    public void testToStringWhenUserIsNotNull() {
        assertEquals("3 | Pulp Fiction | Quentin Tarantino | 1994 | 10 | Test User", movieWithUser.toString().trim());
    }
}
