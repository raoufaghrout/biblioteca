package com.twu.biblioteca;

import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.library.User;
import com.twu.biblioteca.library.libraryitem.Book;
import com.twu.biblioteca.library.libraryitem.LibraryItem;
import com.twu.biblioteca.library.libraryitem.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    private PrintStream printStream;
    private ByteArrayOutputStream byteArrayOutputStream;
    private Library library;

    @Before
    public void setUp() {
        printStream = System.out;
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        List<LibraryItem> libraryItemList = new ArrayList<LibraryItem>() {{
            add(new Book("1", "To Kill a Mockingbird", "Harper Lee", "1960", null));
            add(new Book("2", "Of Mice and Men", "John Steinbeck", "1937", null));
            add(new Movie("3", "Pulp Fiction", "Quentin Tarantino", "1994", "10", null));
            add(new Movie("4", "Jurassic Park", "Steven Spielberg", "1993", "unrated", null));
        }};

        library = new Library(libraryItemList, new ArrayList<LibraryItem>());
        library.setUserSession(new User("123-4567", "Password1", "Test User", "testuser@biblioteca.co.uk", "01234567890"));
    }

    @After
    public void tearDown() {
        System.setOut(printStream);
    }

    @Test
    public void whenIEnterTheListCommandTheListOfItemsIsPresented() {
        library.executeCommand("List");
        assertEquals("1 | To Kill a Mockingbird | Harper Lee | 1960\n" +
                "2 | Of Mice and Men | John Steinbeck | 1937\n" +
                "3 | Pulp Fiction | Quentin Tarantino | 1994 | 10\n" +
                "4 | Jurassic Park | Steven Spielberg | 1993 | unrated\n", byteArrayOutputStream.toString());
    }

    @Test
    public void whenIEnterAnInvalidCommandTheSelectValidMenuOptionMessageIsPresented() {
        library.executeCommand("Incorrect Input String");
        assertEquals("Select a valid menu option!\n", byteArrayOutputStream.toString());
    }

    @Test
    public void whenIEnterTheQuitCommandTheApplicationCloses() {
        library.executeCommand("Quit");
        assertEquals("Thank you for using the Biblioteca!\n", byteArrayOutputStream.toString());
    }

    @Test
    public void whenIEnterTheWithdrawCommandTheItemShouldBeRemovedFromTheListOfItems() {
        library.executeCommand("Withdraw 1");
        library.executeCommand("List");
        assertEquals("Thank you! Enjoy the item.\n" +
                "2 | Of Mice and Men | John Steinbeck | 1937\n" +
                "3 | Pulp Fiction | Quentin Tarantino | 1994 | 10\n" +
                "4 | Jurassic Park | Steven Spielberg | 1993 | unrated\n", byteArrayOutputStream.toString());
    }

    @Test
    public void whenIAttemptToWithdrawAnUnavailableItemTheUnavailabilityMessageIsPresented() {
        library.executeCommand("Withdraw 1");
        library.executeCommand("Withdraw 1");
        assertEquals("Thank you! Enjoy the item.\n" +
                "That item is not available.\n", byteArrayOutputStream.toString());
    }

    @Test
    public void whenIEnterTheReturnCommandTheItemShouldReappearInTheListOfItems() {
        library.executeCommand("Withdraw 1");
        library.executeCommand("Return 1");
        library.executeCommand("List");
        assertEquals("Thank you! Enjoy the item.\n" +
                "Thank you for returning the item.\n" +
                "1 | To Kill a Mockingbird | Harper Lee | 1960\n" +
                "2 | Of Mice and Men | John Steinbeck | 1937\n" +
                "3 | Pulp Fiction | Quentin Tarantino | 1994 | 10\n" +
                "4 | Jurassic Park | Steven Spielberg | 1993 | unrated\n", byteArrayOutputStream.toString());
    }

    @Test
    public void whenIAttemptToReturnAnInvalidItemTheInvalidItemMessageIsPresented() {
        library.executeCommand("Return 2");
        assertEquals("That is not a valid item to return.\n", byteArrayOutputStream.toString());
    }

    @Test
    public void whenIEnterTheInfoCommandMyInformationShouldBePresented() {
        library.executeCommand("Info");
        assertEquals("Test User | testuser@biblioteca.co.uk | 01234567890\n", byteArrayOutputStream.toString());
    }

    @Test
    public void whenIEnterTheLoansCommandTheListOfLoansIsPresented() {
        library.executeCommand("Withdraw 1");
        library.executeCommand("Withdraw 3");
        library.executeCommand("Loans");
        assertEquals("Thank you! Enjoy the item.\n" +
                "Thank you! Enjoy the item.\n" +
                "1 | To Kill a Mockingbird | Harper Lee | 1960 | Test User\n" +
                "3 | Pulp Fiction | Quentin Tarantino | 1994 | 10 | Test User\n", byteArrayOutputStream.toString());
    }
}
