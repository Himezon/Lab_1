package com.lasat.server.commands;

import com.lasat.server.exceptions.IncorrectArgumentException;
import com.lasat.server.exceptions.MissingArgumentException;

/**
 * A class that implements a command to delete a collection item by a given key (id value)
 */
public class RemoveKeyCommand extends Command {
    public RemoveKeyCommand() {
        super("remove_key", "id", "удаляет элемент по заданному id");
    }

    public String execute(CommandController controller, String[] args) {
        String str = "";
        str += "Удаление человека по id " + args[1] + "\n";
        controller.getDataController().getSortedMap().remove(Long.parseLong(args[1]));
        str += "Человек успешно удалён";
        return str;
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {
        if (args.length > 2)
            throw new MissingArgumentException("у команды remove_key лишь один аргумент - id");
        if (args.length == 1)
            throw new MissingArgumentException("id - обязательный аргумент для remove_key");
        long id;
        try {
            id = Long.parseLong(args[1]);
        } catch (NumberFormatException e) {
            throw new IncorrectArgumentException("id должно быть целым числом");
        }
        if (!controller.getDataController().getSortedMap().containsKey(id)) {
            throw new IncorrectArgumentException("человека с таким id в коллекции не существует");
        }
    }
}
