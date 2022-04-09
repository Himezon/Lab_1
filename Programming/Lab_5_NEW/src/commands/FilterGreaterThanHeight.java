package commands;

import data.Person;
import exceptions.IncorrectArgumentException;
import exceptions.MissingArgumentException;

/**
 *A class that implements filtering of collection elements by the specified value of the height field. Outputs elements whose height field value is greater than the specified one
 */
public class FilterGreaterThanHeight extends Command {
    FilterGreaterThanHeight () {
        super("filter_greater_than_height", "height", "выводит элементы, значение поля height которых больше заданного");
    }

    public void execute(CommandController controller, String[] args) {
        if (controller.getDataController().getTreeMap().isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }
        long height = Long.parseLong(args[1]);
        for (Person i: controller.getDataController().getTreeMap().values()) {
            if (i.getHeight() > height) {
                System.out.println(i);
            }
        }

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
