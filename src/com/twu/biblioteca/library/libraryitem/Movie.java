package com.twu.biblioteca.library.libraryitem;

public class Movie extends LibraryItem {

    private String rating;

    public Movie(String title, String year, String number, String author, String rating) {
        super(title, year, number, author);
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s\n", number, title, author, year, rating);
    }
}
