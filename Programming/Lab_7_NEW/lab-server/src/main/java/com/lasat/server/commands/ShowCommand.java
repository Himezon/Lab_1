package com.lasat.server.commands;

import com.lasat.common.data.Person;
import com.lasat.server.exceptions.IncorrectArgumentException;
import com.lasat.server.exceptions.MissingArgumentException;

/**
 * A class that implements the output of information about all elements of the collection
 */
public class ShowCommand extends Command {
    public ShowCommand() {
        super("show", "", "выводит все элементы коллекции");
    }

    public String execute(CommandController controller, String[] args) {
        String str = "";
        if (controller.getDataController().getSortedMap().isEmpty()) {
            return "Коллекция пустая.";
        }
        for (Person i : controller.getDataController().getSortedMap().values())
            str += "Person " + i.getId() + ": " + i;
        return str;
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}
