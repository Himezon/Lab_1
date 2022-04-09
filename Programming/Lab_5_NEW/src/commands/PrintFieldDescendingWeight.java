package commands;

import exceptions.IncorrectArgumentException;
import exceptions.MissingArgumentException;
import data.Person;
import java.util.ArrayList;

/**
 * A class that implements a command to output the elements of a collection in decreasing order of the weight value of each of them
 */
public class PrintFieldDescendingWeight extends Command {
    PrintFieldDescendingWeight () {
        super("print_field_descending_weight", "", "выводит значения поля weight всех элементов в порядке убывания");
    }

    public void execute(CommandController controller, String[] args) {
        if (controller.getDataController().getTreeMap().isEmpty()) {
            System.out.println("Коллекция пуста.");
            return;
        }
        ArrayList<Person> persons = new ArrayList<>(controller.getDataController().getTreeMap().values());
        persons.sort((o1, o2) -> {
            float l1, l2;
            if (o1.getWeight() == null)
                l1 = 0f;
            else
                l1 = o1.getWeight();
            if (o2.getWeight() == null)
                l2 = 0f;
            else
                l2 = o2.getWeight();
            return (l1-l2==0?0:(l1-l2>0?-1:1));
        });
        for (Person i: persons)
            System.out.println(i);
    }

    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}
