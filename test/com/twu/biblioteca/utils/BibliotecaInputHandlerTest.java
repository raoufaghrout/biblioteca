package com.twu.biblioteca.utils;

import com.twu.biblioteca.command.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaInputHandlerTest {

    @Test
    public void whenInputIsParsedCorrectCommandIsConstructed() {
        assertEquals(BibliotecaInputHandler.parseUserInputIntoCommand("List").getClass(), ListCommand.class);
        assertEquals(BibliotecaInputHandler.parseUserInputIntoCommand("Quit").getClass(), QuitCommand.class);
        assertEquals(BibliotecaInputHandler.parseUserInputIntoCommand("Withdraw 1").getClass(), WithdrawCommand.class);
        assertEquals(BibliotecaInputHandler.parseUserInputIntoCommand("Return 2").getClass(), ReturnCommand.class);
        assertEquals(BibliotecaInputHandler.parseUserInputIntoCommand("Info").getClass(), InfoCommand.class);
        assertEquals(BibliotecaInputHandler.parseUserInputIntoCommand("Loans").getClass(), LoansCommand.class);
    }

    @Test
    public void whenInputIsParsedCorrectParameterIsParsed() {
        assertEquals(BibliotecaInputHandler.parseUserInputIntoCommand("List").getParameter(), null);
        assertEquals(BibliotecaInputHandler.parseUserInputIntoCommand("Quit").getParameter(), null);
        assertEquals(BibliotecaInputHandler.parseUserInputIntoCommand("Withdraw 1").getParameter(), "1");
        assertEquals(BibliotecaInputHandler.parseUserInputIntoCommand("Return 2").getParameter(), "2");
        assertEquals(BibliotecaInputHandler.parseUserInputIntoCommand("Info").getParameter(), null);
        assertEquals(BibliotecaInputHandler.parseUserInputIntoCommand("Loans").getParameter(), null);
    }
}
