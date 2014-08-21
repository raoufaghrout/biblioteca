package com.twu.biblioteca.library.loan;

public class LibraryItem implements Comparable {

    protected final String number;
    protected final String title;
    protected final String author;
    protected final String year;

    public LibraryItem(String number, String title, String author, String year) {
        this.number = number;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        LibraryItem libraryItem = (LibraryItem) o;
        return this.getNumber().equals(((libraryItem).getNumber()));
    }

    @Override
    public int compareTo(Object o) {
        LibraryItem libraryItem = (LibraryItem) o;
        return number.compareTo((libraryItem.number));
    }
}
