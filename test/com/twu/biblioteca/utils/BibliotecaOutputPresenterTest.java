package com.twu.biblioteca.utils;


import com.twu.biblioteca.library.loan.Book;
import com.twu.biblioteca.library.loan.LibraryItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaOutputPresenterTest {

    @Test
    public void welcomeMessageAndMenuOptionsArePrinted() {
        assertEquals("Hello! Welcome to the Biblioteca!\n" +
                "Menu Options: List, Withdraw <id>, Return <id>, Quit", BibliotecaOutputPresenter.welcomeMessageAndMenuOptions());
    }

    @Test
    public void commandPromptMessageIsPrinted() {
        assertEquals("Enter a command: ", BibliotecaOutputPresenter.commandPromptMessage());
    }

    @Test
    public void listOfBooksIsPrintedWithAuthorAndDate() {
        List<LibraryItem> listOfItmes = new ArrayList<LibraryItem>() {{
            add(new Book("1", "To Kill a Mockingbird", "Harper Lee", "1960"));
            add(new Book("2", "Of Mice and Men", "John Steinbeck", "1937"));
        }};
        assertEquals("1 | To Kill a Mockingbird | Harper Lee | 1960\n" +
                "2 | Of Mice and Men | John Steinbeck | 1937\n", BibliotecaOutputPresenter.listOfItems(listOfItmes));
    }

    @Test
    public void invalidMenuOptionMessageIsPrinted() {
        assertEquals("Select a valid menu option!", BibliotecaOutputPresenter.invalidCommandMessage());
    }

    @Test
    public void quitMessageIsPrinted() {
        assertEquals("Thank you for using the Biblioteca!", BibliotecaOutputPresenter.quitMessage());
    }

    @Test
    public void onSuccessfulCheckoutThankYouMessageIsPrinted() {
        assertEquals("Thank you! Enjoy the item.", BibliotecaOutputPresenter.successfulCheckoutMessage());
    }

    @Test
    public void onUnsuccessfulCheckoutUnavailabilityMessageIsPrinted() {
        assertEquals("That item is not available.", BibliotecaOutputPresenter.unsuccessfulCheckoutMessage());
    }

    @Test
    public void onSuccessfulReturnThankYouMessageIsPrinted() {
        assertEquals("Thank you for returning the item.", BibliotecaOutputPresenter.successfulReturnMessage());
    }

    @Test
    public void onUnsuccessfulReturnInvalidBookMessageIsPrinted() {
        assertEquals("That is not a valid item to return.", BibliotecaOutputPresenter.unsuccessfulReturnMessage());
    }

    @Test
    public void loginMessageIsPrinted() throws Exception {
        assertEquals("Please Login to the Biblioteca!\n" +
                "Username (Library Number):", BibliotecaOutputPresenter.loginMessage());
    }

    @Test
    public void passwordPromptIsPrinted() throws Exception {
        assertEquals("Password:", BibliotecaOutputPresenter.passwordPromptMessage());
    }
}
