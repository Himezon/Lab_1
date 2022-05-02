package server.commands;

import server.data.Person;
import server.exceptions.IncorrectArgumentException;
import server.exceptions.MissingArgumentException;

/**
 *A class that implements filtering of collection elements by the specified value of the height field. Outputs elements whose height field value is greater than the specified one
 */
public class FilterGreaterThanHeight extends Command {
    public FilterGreaterThanHeight() {
        super("filter_greater_than_height", "height", "выводит элементы, значение поля height которых больше заданного");
    }

    public String execute(CommandController controller, String[] args) {
        if (controller.getDataController().getTreeMap().isEmpty()) {
            return "Коллекция пуста.";
        }
        long height = Long.parseLong(args[1]);
        for (Person i: controller.getDataController().getTreeMap().values()) {
            if (i.getHeight() > height) {
                System.out.println(i);
            }
        }
        return "filter";
    }

    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {
        if (args.length > 2)
            throw new MissingArgumentException("должен присутствовать лишь один аргумент");
        if (args.length == 1)
            throw new MissingArgumentException("height - обязательный аргумент для filter_greater_than_height");
        try {
            if (Long.parseLong(args[1]) <= 0) {
                throw new IncorrectArgumentException("значение height должно быть положительным");
            }
        } catch (NumberFormatException e) {
            throw new IncorrectArgumentException("значение должно являться целым числом");
        }
    }
}
