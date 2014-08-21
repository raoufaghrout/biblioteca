package com.twu.biblioteca.command;

import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.utils.BibliotecaOutputPresenter;

public class ListCommand extends Command {

    protected ListCommand(String parameter) {
        super(parameter);
    }

    @Override
    public void execute(Library library) {
        System.out.print(BibliotecaOutputPresenter.listOfItems(library.getLibraryCatalogue()));
    }
}
