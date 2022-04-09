package commands;

import exceptions.IncorrectArgumentException;
import exceptions.MissingArgumentException;

/**
 * A class that implements the output command of the last entered commands
 */
public class HistoryCommand extends Command{
    HistoryCommand () {
        super("history", "", "выводит последние 12 введённых программ");
    }

    public void execute(CommandController controller, String[] args) {
        for (int i=0;i<controller.getCommandHistory().size();i++) {
            System.out.println((i+1)+") "+controller.getCommandHistory().get(i).getName());
        }
    }

    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}
