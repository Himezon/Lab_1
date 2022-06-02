package com.lasat.server.commands;

import com.lasat.server.exceptions.IncorrectArgumentException;
import com.lasat.server.exceptions.MissingArgumentException;

/**
 * A class that implements a command to output information about all specified commands in the program
 */
public class HelpCommand extends Command {
    public HelpCommand() {
        super("help","","вызывает справку по всем командам");
    }

    public String execute(final CommandController controller, final String[] args) {
        String str = "";
        for (Command i: controller.getAllCommands())
            str += i.getName() + (i.getSignature().equals("") ? "" : " " + i.getSignature()) + " - " + i.getDescription() + "\n";
        return str;
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}
