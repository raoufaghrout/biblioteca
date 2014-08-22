package com.twu.biblioteca.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LoginValidatorTest {

    @Test
    public void shouldReturnCorrectUserWhenPassedTheCorrectCredentials() {
        User actualUser = LoginValidator.getUserFromLibraryNumberAndPassword(validUser().getLibraryNumber(), validUser().getPassword());

        assertEquals(validUser(), actualUser);
    }

    @Test
    public void shouldReturnNullUserWhenPassedIncorrectCredentials() {
        User user = LoginValidator.getUserFromLibraryNumberAndPassword("999-999", "WrongPassword");

        assertNull(user);
    }

    private User validUser() {
        return new User("123-4567", "Password1", "Test User");
    }
}
