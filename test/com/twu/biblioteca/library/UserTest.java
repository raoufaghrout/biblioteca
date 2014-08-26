package com.twu.biblioteca.library;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {

    protected User user;

    @Before
    public void setUp() throws Exception {
        user = new User("123-4567", "Password1", "Test User", "testuser@biblioteca.co.uk", "01234567890");
    }

    @Test
    public void testEquality() {
        assertTrue(user.equals(new User("123-4567", "Password1", "Test User", "testuser@biblioteca.co.uk", "01234567890")));
    }

    @Test
    public void testToString() {
        assertEquals("Test User | testuser@biblioteca.co.uk | 01234567890\n", user.toString());
    }
}
