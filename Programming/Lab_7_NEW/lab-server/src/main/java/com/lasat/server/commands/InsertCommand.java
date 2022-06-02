package com.lasat.server.commands;

import com.lasat.common.data.Person;
import com.lasat.server.exceptions.IncorrectArgumentException;
import com.lasat.server.exceptions.MissingArgumentException;

/**
 * A class that implements the command to insert a new Person element into the collection
 */
public class InsertCommand extends Command {
    public InsertCommand() {
        super("insert", "id {element}", "добавить новый элемент с заданным id");
    }

    public String execute(CommandController controller, String[] args) {
        Person person = controller.getDataController().getConsoleController().createPerson();
        if (person == null) {
            return "Коллекция не была изменена.";
        }
        person.setId(Long.parseLong(args[1]));
        controller.getDataController().addPerson(person);
        return "Человек был успешно добавлен в коллекцию.";
    }
    public void checkArgs(final CommandController controller, final String[] args) throws IncorrectArgumentException, MissingArgumentException {
        if (args.length > 2)
            throw new MissingArgumentException("у команды insert лишь один аргумент - id");
        if (args.length == 1)
            throw new MissingArgumentException("id - обязательный аргумент для insert");
        long id;
        try {
            id = Long.parseLong(args[1]);
        } catch (NumberFormatException e) {
            throw new IncorrectArgumentException ("id должно быть целым числом");
        }
        if (!Person.checkUniqueId(controller.getDataController().getSortedMap(), id))
            throw new IncorrectArgumentException("id должен быть уникальным для этой коллекции");
    }
}
