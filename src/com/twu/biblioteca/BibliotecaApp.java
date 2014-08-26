package com.twu.biblioteca;

import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.library.libraryitem.Book;
import com.twu.biblioteca.library.libraryitem.LibraryItem;
import com.twu.biblioteca.library.libraryitem.Movie;
import com.twu.biblioteca.utils.LoginController;

import java.util.ArrayList;
import java.util.List;

class BibliotecaApp {

    private static List<LibraryItem> libraryCatalogue = new ArrayList<LibraryItem>() {{
        add(new Book("1", "To Kill a Mockingbird", "Harper Lee", "1960", null));
        add(new Book("2", "Of Mice and Men", "John Steinbeck", "1937", null));
        add(new Movie("3", "Pulp Fiction", "Quentin Tarantino", "1994", "10", null));
        add(new Movie("4", "Jurassic Park", "Steven Spielberg", "1993", "unrated", null));
    }};

    public static void main(String[] args) {
        Library library = new Library(libraryCatalogue, new ArrayList<LibraryItem>());
        library.start(LoginController.attemptLogin());
    }
}
