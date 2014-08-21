package com.twu.biblioteca.library;

public class Magazine extends LibraryItem {

    private String issueNumber;

    public Magazine(String number, String title, String author, String year, String issueNumber) {
        super(number, title, author, year);
        this.issueNumber = issueNumber;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s\n", number, title, author, year, issueNumber);
    }
}
