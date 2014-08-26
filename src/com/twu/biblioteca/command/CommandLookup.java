package com.twu.biblioteca.command;

public enum CommandLookup {

    LIST(new ListCommand(null)),

    QUIT(new QuitCommand(null)),

    WITHDRAW(new WithdrawCommand(null)),

    RETURN(new ReturnCommand(null)),

    INFO(new InfoCommand(null)),

    LOANS(new LoansCommand(null));

    private final Command command;

    CommandLookup(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}