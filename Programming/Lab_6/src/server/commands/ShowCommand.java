package server.commands;

import server.data.Person;
import server.exceptions.IncorrectArgumentException;
import server.exceptions.MissingArgumentException;

/**
 * A class that implements the output of information about all elements of the collection
 */
public class ShowCommand extends Command {
    public ShowCommand() {
        super("show", "", "выводит все элементы коллекции");
    }

    public String execute(CommandController controller, String[] args) {
        String str = "";
        if (controller.getDataController().getTreeMap().isEmpty()) {
            return "Коллекция пустая.";
        }
        for (Person i : controller.getDataController().getTreeMap().values())
            str += "Person " + i.getId() + ": " + i;
        return str;
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}
