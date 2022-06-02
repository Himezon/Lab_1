package com.lasat.server.commands;

import com.lasat.server.exceptions.IncorrectArgumentException;
import com.lasat.server.exceptions.MissingArgumentException;

/**
 * A class that implements a command to output information about a collection
 */
public class InfoCommand extends Command {
    public InfoCommand() {
        super("info", "", "выводит информацию о коллекции");
    }

    public String execute(CommandController controller, String[] args) {
        String str = "";
        str += "Тип коллекции - SortedMap, коллекция состоит из "+controller.getDataController().getSortedMap().size()+" элементов.\n";
        str += "Ключом у коллекции выступает значение id.";
        return str;
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}
