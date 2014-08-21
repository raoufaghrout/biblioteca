package com.twu.biblioteca.command;

import com.twu.biblioteca.library.Library;

public abstract class Command {

    private String parameter;

    protected Command(String parameter) {
        this.parameter = parameter;
    }

    public abstract void execute(Library library);

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
