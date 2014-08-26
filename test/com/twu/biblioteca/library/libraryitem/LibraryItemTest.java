package com.twu.biblioteca.library.libraryitem;

import com.twu.biblioteca.library.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryItemTest {

    protected User user;
    protected Book bookWithUser;
    protected Book bookWithNoUser;
    protected Movie movieWithUser;
    protected Movie movieWithNoUser;

    protected List<LibraryItem> libraryItemList;

    @Before
    public void setUp() {
        user = new User("123-4567", "Password1", "Test User", "testuser@biblioteca.co.uk", "01234567890");
        bookWithUser = new Book("1", "To Kill a MockingBird", "Harper Lee", "1960", user);
        bookWithNoUser = new Book("1", "To Kill a MockingBird", "Harper Lee", "1960", null);
        movieWithUser = new Movie("3", "Pulp Fiction", "Quentin Tarantino", "1994", "10", user);
        movieWithNoUser = new Movie("3", "Pulp Fiction", "Quentin Tarantino", "1994", "10", null);

        libraryItemList = new ArrayList<LibraryItem>() {{
            add(new Movie("4", "Jurassic Park", "Steven Spielberg", "1993", "unrated", null));
            add(new Book("1", "To Kill a Mockingbird", "Harper Lee", "1960", null));
            add(new Movie("3", "Pulp Fiction", "Quentin Tarantino", "1994", "10", null));
            add(new Book("2", "Of Mice and Men", "John Steinbeck", "1937", null));
        }};
    }

    @Test
    public void testEquality() {
        assertTrue(bookWithNoUser.equals(new Book("1", "To Kill a MockingBird", "Harper Lee", "1960", null)));
        assertTrue(movieWithNoUser.equals(new Movie("3", "Pulp Fiction", "Quentin Tarantino", "1994", "10", null)));
    }

    @Test
    public void testSort() {
        Collections.sort(libraryItemList);
        assertEquals(new Book("1", "To Kill a Mockingbird", "Harper Lee", "1960", null), libraryItemList.get(0));
        assertEquals(new Book("2", "Of Mice and Men", "John Steinbeck", "1937", null), libraryItemList.get(1));
        assertEquals(new Movie("3", "Pulp Fiction", "Quentin Tarantino", "1994", "10", null), libraryItemList.get(2));
        assertEquals(new Movie("4", "Jurassic Park", "Steven Spielberg", "1993", "unrated", null), libraryItemList.get(3));
    }
}
