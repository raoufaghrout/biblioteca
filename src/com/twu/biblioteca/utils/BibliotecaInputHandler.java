package com.twu.biblioteca.utils;

import com.twu.biblioteca.command.Command;
import com.twu.biblioteca.command.CommandLookup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaInputHandler {

    public static String commandPrompt() {
        System.out.print(BibliotecaOutputPresenter.commandPromptMessage());
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

        try {
            return bufferRead.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Command parseInputIntoCommand(String input) {
        Command command = null;
        String[] splitInput = input.split(" ");

        try {
            command = CommandLookup.valueOf(splitInput[0].trim().toUpperCase()).getCommand();
        } catch (Exception ignored) {

        }

        if (splitInput.length > 1 && command != null) command.setParameter(splitInput[1].trim());

        return command;
    }
}
