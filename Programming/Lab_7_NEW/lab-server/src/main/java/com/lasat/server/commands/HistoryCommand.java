package com.lasat.server.commands;

import com.lasat.server.exceptions.IncorrectArgumentException;
import com.lasat.server.exceptions.MissingArgumentException;

/**
 * A class that implements the output command of the last entered commands
 */
public class HistoryCommand extends Command{
    public HistoryCommand() {
        super("history", "", "выводит последние 12 введённых программ");
    }

    public String execute(CommandController controller, String[] args) {
        String str = "";
        for (int i=0;i<controller.getCommandHistory().size();i++) {
            str += (i+1)+") "+controller.getCommandHistory().get(i).getName() + "\n";
        }
        return str;
    }

    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}
