package com.twu.biblioteca.utils;

import com.twu.biblioteca.library.User;
import com.twu.biblioteca.library.libraryitem.LibraryItem;

import java.util.List;

public class BibliotecaOutputPresenter {

    public static String welcomeMessageAndMenuOptions() {
        return "Hello! Welcome to the Biblioteca!\n" +
                "Menu Options: List, Withdraw <id>, Return <id>, Loans, Info, Quit";
    }

    public static String commandPromptMessage() {
        return "Enter a command: ";
    }

    public static String listOfItems(List<LibraryItem> itemList) {
        StringBuilder stringBuilder = new StringBuilder();

        for (LibraryItem libraryItem : itemList) stringBuilder.append(libraryItem.toString());

        return stringBuilder.toString();
    }

    public static String invalidCommandMessage() {
        return "Select a valid menu option!";
    }

    public static String successfulCheckoutMessage() {
        return "Thank you! Enjoy the item.";
    }

    public static String unsuccessfulCheckoutMessage() {
        return "That item is not available.";
    }

    public static String successfulReturnMessage() {
        return "Thank you for returning the item.";
    }

    public static String unsuccessfulReturnMessage() {
        return "That is not a valid item to return.";
    }

    public static String quitMessage() {
        return "Thank you for using the Biblioteca!";
    }

    public static String loginPromptMessage() {
        return "Please Login to the Biblioteca!\n" +
                "Library Number:";
    }

    public static String passwordPromptMessage() {
        return "Password:";
    }

    public static String userInfo(User user) {
        return user.toString();
    }
}
