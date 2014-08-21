package com.twu.biblioteca.command;

import com.twu.biblioteca.library.Library;

public class ReturnCommand extends Command {

    protected ReturnCommand(String parameter) {
        super(parameter);
    }

    @Override
    public void execute(Library library) {
        library.returnBook(getParameter());
    }
}
