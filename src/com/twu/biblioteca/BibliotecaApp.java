package com.twu.biblioteca;

import com.twu.biblioteca.library.*;
import com.twu.biblioteca.utils.BibliotecaOutputPresenter;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private static List<LibraryItem> libraryCatalogue = new ArrayList<LibraryItem>() {{
        add(new Book("1", "To Kill a Mockingbird", "Harper Lee", "1960"));
        add(new Book("2", "Of Mice and Men", "John Steinbeck", "1937"));
        add(new Movie("3", "Pulp Fiction", "Quentin Tarantino", "1994", "10"));
        add(new Movie("4", "Jurassic Park", "Steven Spielberg", "1993", "unrated"));
        add(new Magazine("5", "Wired", "Multiple", "2014", "June"));
    }};

    public static void main(String[] args) {
        System.out.println(BibliotecaOutputPresenter.welcomeMessageAndMenuOptions());
        Library library = new Library(libraryCatalogue, new ArrayList<LibraryItem>());
        library.start();
    }
}
