package com.twu.biblioteca.library.libraryitem;

import com.twu.biblioteca.library.User;

public class LibraryItem implements Comparable {

    protected final String number;
    protected final String title;
    protected final String author;
    protected final String year;
    protected User loanedBy;

    public LibraryItem(String number, String title, String author, String year, User loanedBy) {
        this.number = number;
        this.title = title;
        this.author = author;
        this.year = year;
        this.loanedBy = loanedBy;
    }

    public String getNumber() {
        return number;
    }

    public void setLoanedBy(User loanedBy) {
        this.loanedBy = loanedBy;
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
