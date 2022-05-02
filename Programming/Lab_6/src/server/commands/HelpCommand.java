package server.commands;

import server.Server;
import server.exceptions.IncorrectArgumentException;
import server.exceptions.MissingArgumentException;

/**
 * A class that implements a command to output information about all specified commands in the program
 */
public class HelpCommand extends Command {
    public HelpCommand() {
        super("help","","вызывает справку по всем командам");
    }

    public String execute(final CommandController controller, final String[] args) {
        for (Command i: controller.getAllCommands())
            System.out.println(i.getName() + (i.getSignature().equals("") ? "" : " " + i.getSignature()) + " - " + i.getDescription());
        return "";
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}
