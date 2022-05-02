package server.commands;

import server.data.Person;
import server.dataController.ConsoleController;
import server.exceptions.IncorrectArgumentException;
import server.exceptions.MissingArgumentException;

/**
 * A class that implements updating the values of a collection element by a given key (id)
 */
public class UpdateCommand extends Command {
    public UpdateCommand() {
        super("update", "id {element}", "обновляет значение элемента коллекции, id которого равен заданному");
    }

    public String execute(CommandController controller, String[] args) {
        Person person = controller.getDataController().getConsoleController().updatePerson(
                controller.getDataController().getTreeMap().get(Long.parseLong(args[1]))
        );
        controller.getDataController().getTreeMap().remove(Long.parseLong(args[1]));
        controller.getDataController().addPerson(person);
        return "update";
    }

    @Override
    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {
        if (args.length > 2)
            throw new MissingArgumentException("должен присутствовать лишь один аргумент");
        if (args.length == 1)
            throw new MissingArgumentException("id {element} - обязательный аргумент для filter_greater_than_height");
        try {
            if (Long.parseLong(args[1]) <= 0) {
                throw new IncorrectArgumentException("значение id должно быть положительным");
            }
        } catch (NumberFormatException e) {
            throw new IncorrectArgumentException("значение должно являться целым числом");
        }
        if (Person.checkUniqueId(controller.getDataController().getTreeMap(), Long.parseLong(args[1])))
            throw new IncorrectArgumentException("элемента с таким id не существует");
    }
}
