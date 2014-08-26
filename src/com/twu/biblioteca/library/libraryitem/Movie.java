package com.twu.biblioteca.library.libraryitem;

import com.twu.biblioteca.library.User;

public class Movie extends LibraryItem {

    private String rating;

    public Movie(String title, String year, String number, String author, String rating, User loanedBy) {
        super(title, year, number, author, loanedBy);
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s" +
                (loanedBy != null ? " | " + loanedBy.getName() : "") +
                "\n", number, title, author, year, rating);
    }
}
