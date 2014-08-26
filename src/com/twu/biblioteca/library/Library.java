package com.twu.biblioteca.library;

import com.twu.biblioteca.command.Command;
import com.twu.biblioteca.library.libraryitem.LibraryItem;
import com.twu.biblioteca.utils.BibliotecaInputHandler;
import com.twu.biblioteca.utils.BibliotecaOutputPresenter;

import java.util.Collections;
import java.util.List;

public class Library {

    private final List<LibraryItem> libraryCatalogue;
    private final List<LibraryItem> withdrawnItemList;
    private boolean running;
    private User userSession;

    public Library(List<LibraryItem> libraryCatalogue, List<LibraryItem> withdrawnItemList) {
        this.libraryCatalogue = libraryCatalogue;
        this.withdrawnItemList = withdrawnItemList;
    }

    public void start(User user) {
        this.setRunning(true);
        this.setUserSession(user);
        System.out.println(BibliotecaOutputPresenter.welcomeMessageAndMenuOptions());

        while (running) executeCommand(BibliotecaInputHandler.commandPrompt());
    }

    public void executeCommand(String commandAsString) {
        Command command = BibliotecaInputHandler.parseUserInputIntoCommand(commandAsString);

        if (command == null) System.out.println(BibliotecaOutputPresenter.invalidCommandMessage());
        else command.execute(this);
    }

    public void withdrawItem(String number) {
        LibraryItem libraryItem = findItem(libraryCatalogue, number);

        if (libraryItem != null) {
            libraryCatalogue.remove(libraryItem);
            withdrawnItemList.add(libraryItem);
            libraryItem.setLoanedBy(userSession);
            System.out.println(BibliotecaOutputPresenter.successfulCheckoutMessage());
            return;
        }

        System.out.println(BibliotecaOutputPresenter.unsuccessfulCheckoutMessage());
    }

    public void returnBook(String bookNumber) {
        LibraryItem libraryItem = findItem(withdrawnItemList, bookNumber);

        if (libraryItem != null) {
            libraryCatalogue.add(libraryItem);
            withdrawnItemList.remove(libraryItem);
            libraryItem.setLoanedBy(null);
            Collections.sort(libraryCatalogue);
            System.out.println(BibliotecaOutputPresenter.successfulReturnMessage());
            return;
        }

        System.out.println(BibliotecaOutputPresenter.unsuccessfulReturnMessage());
    }

    public LibraryItem findItem(List<LibraryItem> itemList, String number) {
        for (LibraryItem libraryItem : itemList) if (libraryItem.getNumber().equals(number)) return libraryItem;

        return null;
    }

    public void quit() {
        System.out.println(BibliotecaOutputPresenter.quitMessage());
        running = false;
    }

    public List<LibraryItem> getLibraryCatalogue() {
        return libraryCatalogue;
    }

    public List<LibraryItem> getWithdrawnItemList() {
        return withdrawnItemList;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public User getUserSession() {
        return userSession;
    }

    public void setUserSession(User userSession) {
        this.userSession = userSession;
    }
}
