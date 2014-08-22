package com.twu.biblioteca;

import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.library.loan.Book;
import com.twu.biblioteca.library.loan.LibraryItem;
import com.twu.biblioteca.library.loan.Movie;

import java.util.ArrayList;
import java.util.List;

class BibliotecaApp {

    private static List<LibraryItem> libraryCatalogue = new ArrayList<LibraryItem>() {{
        add(new Book("1", "To Kill a Mockingbird", "Harper Lee", "1960"));
        add(new Book("2", "Of Mice and Men", "John Steinbeck", "1937"));
        add(new Movie("3", "Pulp Fiction", "Quentin Tarantino", "1994", "10"));
        add(new Movie("4", "Jurassic Park", "Steven Spielberg", "1993", "unrated"));
    }};

    public static void main(String[] args) {
        Library library = new Library(libraryCatalogue, new ArrayList<LibraryItem>());
        library.login();
    }
}
