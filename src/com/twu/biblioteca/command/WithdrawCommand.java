package com.twu.biblioteca.command;

import com.twu.biblioteca.library.Library;

public class WithdrawCommand extends Command {

    protected WithdrawCommand(String parameter) {
        super(parameter);
    }

    @Override
    public void execute(Library library) {
        library.withdrawItem(getParameter());
    }
}
