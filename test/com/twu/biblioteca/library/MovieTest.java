package com.twu.biblioteca.library;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest extends LibraryItemTest {

    @Test
    public void testToString() {
        assertEquals("3 | Pulp Fiction | Quentin Tarantino | 1994 | 10", movie.toString().trim());
    }
}
