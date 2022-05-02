package server.commands;

import server.exceptions.IncorrectArgumentException;
import server.exceptions.MissingArgumentException;

/**
 * A class that implements a command to output information about a collection
 */
public class InfoCommand extends Command {
    public InfoCommand() {
        super("info", "", "выводит информацию о коллекции");
    }

    public String execute(CommandController controller, String[] args) {
        System.out.println("Тип коллекции - TreeMap, коллекция состоит из "+controller.getDataController().getTreeMap().size()+" элементов.");
        System.out.println("Ключом у коллекции выступает значение id.");
        return "info";
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}
