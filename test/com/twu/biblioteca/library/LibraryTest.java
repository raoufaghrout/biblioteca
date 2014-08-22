package com.twu.biblioteca.library;

import com.twu.biblioteca.library.libraryitem.Book;
import com.twu.biblioteca.library.libraryitem.LibraryItem;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    private Library library;

    @Test
    public void whenIWithdrawAnItemThatExistsItIsRemovedFromTheItemList() {
        library = new Library(listContainingOneBook(), new ArrayList<LibraryItem>());
        library.withdrawItem("1");
        assertTrue(library.getLibraryCatalogue().isEmpty());
    }

    @Test
    public void whenIWithdrawAnItemThatExistsItShouldBeAddedIntoTheListOfWithdrawnItems() {
        library = new Library(listContainingOneBook(), new ArrayList<LibraryItem>());
        library.withdrawItem("1");
        assertEquals(new Book("1", "To Kill a MockingBird", "Harper Lee", "1960"), library.getWithdrawnItemList().get(0));
    }

    @Test
    public void whenIReturnAnItemTheHasBeenWithdrawnItShouldBeRemovedFromTheListOfWithdrawnItems() {
        library = new Library(new ArrayList<LibraryItem>(), listContainingOneBook());
        library.returnBook("1");
        assertTrue(library.getWithdrawnItemList().isEmpty());
    }

    @Test
    public void whenIReturnAnItemThatHasBeenWithdrawnItIsAddedToTheItemList() {
        library = new Library(new ArrayList<LibraryItem>(), listContainingOneBook());
        library.returnBook("1");
        assertEquals(new Book("1", "To Kill a MockingBird", "Harper Lee", "1960"), library.getLibraryCatalogue().get(0));
    }

    @Test
    public void whenIAttemptToFindAnItemThatExistsTheCorrectItemIsReturned() {
        library = new Library(listContainingOneBook(), new ArrayList<LibraryItem>());
        assertEquals(new Book("1", "To Kill a MockingBird", "Harper Lee", "1960"), library.findItem(library.getLibraryCatalogue(), "1"));
    }

    @Test
    public void whenIAttemptToQuitTheLibraryItTerminatesCorrectly() throws Exception {
        library = new Library(new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>());
        library.quit();
        assertEquals(library.isRunning(), false);
    }

    private ArrayList<LibraryItem> listContainingOneBook() {
        return new ArrayList<LibraryItem>() {{
            add(new Book("1", "To Kill a Mockingbird", "Harper Lee", "1960"));
        }};
    }
}
