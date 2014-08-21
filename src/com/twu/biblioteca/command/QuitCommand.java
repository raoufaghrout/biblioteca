package com.twu.biblioteca.command;

import com.twu.biblioteca.library.Library;

public class QuitCommand extends Command {

    protected QuitCommand(String parameter) {
        super(parameter);
    }

    @Override
    public void execute(Library library) {
        library.quit();
    }
}
