package com.twu.biblioteca.library.libraryitem;

import com.twu.biblioteca.library.User;

public class Book extends LibraryItem {

    public Book(String number, String title, String author, String year, User loanedBy) {
        super(number, title, author, year, loanedBy);
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s" +
                (loanedBy != null ? " | " + loanedBy.getName() : "") +
                "\n", number, title, author, year);
    }
}
