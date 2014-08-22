package com.twu.biblioteca.utils;

import com.twu.biblioteca.library.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LoginControllerTest {

    @Test
    public void shouldReturnCorrectUserWhenPassedTheCorrectCredentials() {
        User actualUser = LoginController.getUserFromLibraryNumberAndPassword(validUser().getLibraryNumber(), validUser().getPassword());

        assertEquals(validUser(), actualUser);
    }

    @Test
    public void shouldReturnNullUserWhenPassedIncorrectCredentials() {
        User user = LoginController.getUserFromLibraryNumberAndPassword("999-999", "WrongPassword");

        assertNull(user);
    }

    private User validUser() {
        return new User("123-4567", "Password1", "Test User", "testuser@biblioteca.co.uk", "01234567890");
    }
}
