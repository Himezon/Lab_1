package com.lasat.server.commands;

import com.lasat.server.exceptions.IncorrectArgumentException;
import com.lasat.server.exceptions.MissingArgumentException;

/**
 * A class that implements the command to interrupt the program
 */
public class ExitCommand extends Command {
    public ExitCommand() {
        super("exit", "", "завершает программу (без сохранения в файл)");
    }

    public String execute(CommandController controller, String[] args) {
        System.out.println("Прерывание работы программы...");
        System.exit(0);
        return "";
    }

    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}

