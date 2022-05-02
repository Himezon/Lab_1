package server.commands;

import server.exceptions.IncorrectArgumentException;
import server.exceptions.MissingArgumentException;

/**
 * Implements the collection cleanup command
 */
public class ClearCommand extends Command {
    public ClearCommand() {
        super("clear", "", "очищает коллекцию");
    }

    public String execute(CommandController controller, String[] args) {
        if (controller.getDataController().getTreeMap().isEmpty()) {
            return "Коллекция уже пуста.";
        }
        controller.getDataController().getTreeMap().clear();
        System.out.println("Коллекция успешно очищена.");
        return "clear";
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}
