package com.twu.biblioteca.utils;

import com.twu.biblioteca.command.ListCommand;
import com.twu.biblioteca.command.QuitCommand;
import com.twu.biblioteca.command.ReturnCommand;
import com.twu.biblioteca.command.WithdrawCommand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaInputHandlerTest {

    @Test
    public void whenInputIsParsedCorrectCommandIsConstructed() {
        assertEquals(BibliotecaInputHandler.parseInputIntoCommand("List").getClass(), ListCommand.class);
        assertEquals(BibliotecaInputHandler.parseInputIntoCommand("Quit").getClass(), QuitCommand.class);
        assertEquals(BibliotecaInputHandler.parseInputIntoCommand("Withdraw 1").getClass(), WithdrawCommand.class);
        assertEquals(BibliotecaInputHandler.parseInputIntoCommand("Return 2").getClass(), ReturnCommand.class);
    }

    @Test
    public void whenInputIsParsedCorrectParameterIsParsed() {
        assertEquals(BibliotecaInputHandler.parseInputIntoCommand("List").getParameter(), null);
        assertEquals(BibliotecaInputHandler.parseInputIntoCommand("Quit").getParameter(), null);
        assertEquals(BibliotecaInputHandler.parseInputIntoCommand("Withdraw 1").getParameter(), "1");
        assertEquals(BibliotecaInputHandler.parseInputIntoCommand("Return 2").getParameter(), "2");
    }
}
