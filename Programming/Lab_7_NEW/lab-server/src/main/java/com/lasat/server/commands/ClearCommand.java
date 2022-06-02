package com.lasat.server.commands;

import com.lasat.server.exceptions.IncorrectArgumentException;
import com.lasat.server.exceptions.MissingArgumentException;

/**
 * Implements the collection cleanup command
 */
public class ClearCommand extends Command {
    public ClearCommand() {
        super("clear", "", "очищает коллекцию");
    }

    public String execute(CommandController controller, String[] args) {
        if (controller.getDataController().getDbFiller().getSortedMapPersons().isEmpty()) {
            return "Коллекция уже пуста.";
        }
        controller.getDataController().getSortedMap().clear();
        return "Коллекция успешно очищена.";
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}
