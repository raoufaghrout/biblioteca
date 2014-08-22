package com.twu.biblioteca.utils;

import java.util.ArrayList;
import java.util.List;

public class LoginValidator {

    private static List<User> libraryUsers = new ArrayList<User>() {{
        add(new User("123-4567", "Password1", "Test User"));
    }};

    public static User getUserFromLibraryNumberAndPassword(String libraryNumber, String password) {

        for (User user : libraryUsers) {
            if (user.getLibraryNumber().equals(libraryNumber) && user.getPassword().equals(password))
                return user;
        }

        return null;
    }
}
