package com.lasat.server.commands;

import com.lasat.common.data.Person;
import com.lasat.server.exceptions.IncorrectArgumentException;
import com.lasat.server.exceptions.MissingArgumentException;

import java.util.ArrayList;

/**
 * A class that implements a command to output the elements of a collection in decreasing order of the weight value of each of them
 */
public class PrintFieldDescendingWeight extends Command {
    public PrintFieldDescendingWeight() {
        super("print_field_descending_weight", "", "выводит значения поля weight всех элементов в порядке убывания");
    }

    public String execute(CommandController controller, String[] args) {
        String str = "";
        if (controller.getDataController().getSortedMap().isEmpty()) {
            return "Коллекция пуста.";
        }
        ArrayList<Person> persons = new ArrayList<>(controller.getDataController().getSortedMap().values());
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
            str += i + "\n";
        return str;
    }

    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {

    }
}
