package com.twu.biblioteca.library;

import com.twu.biblioteca.library.loan.Book;
import com.twu.biblioteca.library.loan.LibraryItem;
import com.twu.biblioteca.library.loan.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryItemTest {

    protected Book book;
    protected Movie movie;
    protected List<LibraryItem> libraryItemList;

    @Before
    public void setUp() {
        book = new Book("1", "To Kill a MockingBird", "Harper Lee", "1960");
        movie = new Movie("3", "Pulp Fiction", "Quentin Tarantino", "1994", "10");

        libraryItemList = new ArrayList<LibraryItem>() {{
            add(new Movie("4", "Jurassic Park", "Steven Spielberg", "1993", "unrated"));
            add(new Book("1", "To Kill a Mockingbird", "Harper Lee", "1960"));
            add(new Movie("3", "Pulp Fiction", "Quentin Tarantino", "1994", "10"));
            add(new Book("2", "Of Mice and Men", "John Steinbeck", "1937"));
        }};
    }

    @Test
    public void testEquality() {
        assertTrue(book.equals(new Book("1", "To Kill a MockingBird", "Harper Lee", "1960")));
        assertTrue(movie.equals(new Movie("3", "Pulp Fiction", "Quentin Tarantino", "1994", "10")));
    }

    @Test
    public void testSort() {
        Collections.sort(libraryItemList);
        assertEquals(new Book("1", "To Kill a Mockingbird", "Harper Lee", "1960"), libraryItemList.get(0));
        assertEquals(new Book("2", "Of Mice and Men", "John Steinbeck", "1937"), libraryItemList.get(1));
        assertEquals(new Movie("3", "Pulp Fiction", "Quentin Tarantino", "1994", "10"), libraryItemList.get(2));
        assertEquals(new Movie("4", "Jurassic Park", "Steven Spielberg", "1993", "unrated"), libraryItemList.get(3));
    }
}
