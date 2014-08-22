package com.twu.biblioteca.library.libraryitem;

public class Book extends LibraryItem {

    public Book(String number, String title, String author, String year) {
        super(number, title, author, year);
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s\n", number, title, author, year);
    }
}
