package com.twu.biblioteca.utils;

import com.twu.biblioteca.library.User;
import com.twu.biblioteca.library.libraryitem.Book;
import com.twu.biblioteca.library.libraryitem.LibraryItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaOutputPresenterTest {

    @Test
    public void welcomeMessageAndMenuOptionsArePrinted() {
        assertEquals("Hello! Welcome to the Biblioteca!\n" +
                "Menu Options: List, Withdraw <id>, Return <id>, Loans, Info, Quit", BibliotecaOutputPresenter.welcomeMessageAndMenuOptions());
    }

    @Test
    public void commandPromptMessageIsPrinted() {
        assertEquals("Enter a command: ", BibliotecaOutputPresenter.commandPromptMessage());
    }

    @Test
    public void listOfBooksIsPrintedWithAuthorAndDate() {
        List<LibraryItem> listOfItmes = new ArrayList<LibraryItem>() {{
            add(new Book("1", "To Kill a Mockingbird", "Harper Lee", "1960", null));
            add(new Book("2", "Of Mice and Men", "John Steinbeck", "1937", null));
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
    public void loginMessageIsPrinted() {
        assertEquals("Please Login to the Biblioteca!\n" +
                "Library Number:", BibliotecaOutputPresenter.loginPromptMessage());
    }

    @Test
    public void passwordPromptIsPrinted() {
        assertEquals("Password:", BibliotecaOutputPresenter.passwordPromptMessage());
    }

    @Test
    public void userInfoIsPrinted() {
        User user = new User("123-4567", "Password1", "Test User", "testuser@biblioteca.co.uk", "01234567890");
        assertEquals("Test User | testuser@biblioteca.co.uk | 01234567890\n", BibliotecaOutputPresenter.userInfo(user));
    }
}
