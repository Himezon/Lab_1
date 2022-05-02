package server.commands;

import server.exceptions.IncorrectArgumentException;
import server.exceptions.MissingArgumentException;

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
        return "";
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}
