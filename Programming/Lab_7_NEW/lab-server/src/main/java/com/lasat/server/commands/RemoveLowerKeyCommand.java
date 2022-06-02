package com.lasat.server.commands;

import com.lasat.common.data.Person;
import com.lasat.server.exceptions.IncorrectArgumentException;
import com.lasat.server.exceptions.MissingArgumentException;

import java.util.ArrayList;

/**
 * A class that implements a command to delete all elements of a collection whose key value (id) is less than the specified one
 */
public class RemoveLowerKeyCommand extends  Command {
    public RemoveLowerKeyCommand() {
        super("remove_lower_key", "id", "удаляет из коллекции все элементы, ключ которых меньше, чем заданный");
    }

    public String execute(CommandController controller, String[] args) {
        if (controller.getDataController().getSortedMap().isEmpty()) {
            return "Коллекция пуста.";
        }
        long id = Long.parseLong(args[1]);
        ArrayList<Long> ids = new ArrayList<>();
        for (Person i: controller.getDataController().getSortedMap().values()) {
            if (i.getId() < id)
                ids.add(i.getId());
        }
        for (Long i: ids)
            controller.getDataController().getSortedMap().remove(i);
        return "Удаление выполнено.";
    }

    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {
        if (args.length > 2)
            throw new MissingArgumentException("у команды remove_lower_key лишь один аргумент");
        if (args.length == 1)
            throw new MissingArgumentException("для команды remove_lower_key нужен один аргумент");
        long id;
        try {
            id = Long.parseLong(args[1]);
        } catch (NumberFormatException e) {
            throw new IncorrectArgumentException ("значение должно быть целым числом");
        }
    }
}
