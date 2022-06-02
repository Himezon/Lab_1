package com.lasat.server.commands;

import com.lasat.server.exceptions.IncorrectArgumentException;
import com.lasat.server.exceptions.MissingArgumentException;

/**
 * A class that implements saving collection data to a file at a specified path
 */
public class SaveCommand extends Command {
    public SaveCommand() {
        super("save", "", "сохраняет коллекцию в файл");
    }

    @Override
    public String execute(CommandController controller, String[] args) {
        controller.getDataController().getFileController().writeCSVFile(controller.getDataController().getPath());
        return "Сохранение выполнено.";
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}
