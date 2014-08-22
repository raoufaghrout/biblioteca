package com.twu.biblioteca.command;

import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.utils.BibliotecaOutputPresenter;

public class InfoCommand extends Command {

    protected InfoCommand(String parameter) {
        super(parameter);
    }

    @Override
    public void execute(Library library) {
        System.out.print(BibliotecaOutputPresenter.userInfo(library.getUserSession()));
    }
}
