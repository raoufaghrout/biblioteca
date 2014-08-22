package com.twu.biblioteca.utils;

import com.twu.biblioteca.library.User;

import java.util.ArrayList;
import java.util.List;

public class LoginController {

    private static List<User> libraryUsers = new ArrayList<User>() {{
        add(new User("123-4567", "Password1", "Test User", "testuser@biblioteca.co.uk", "01234567890"));
    }};

    public static User getUserFromLibraryNumberAndPassword(String libraryNumber, String password) {

        for (User user : libraryUsers) {
            if (user.getLibraryNumber().equals(libraryNumber) && user.getPassword().equals(password))
                return user;
        }

        return null;
    }

    public static User attemptLogin() {
        boolean loggedIn = false;
        User user = null;

        while (!loggedIn) {
            user = getUserFromLibraryNumberAndPassword(BibliotecaInputHandler.loginPrompt(), BibliotecaInputHandler.passwordPrompt());

            if (user != null) loggedIn = true;
        }

        return user;
    }
}
