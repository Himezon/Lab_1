package com.lasat.server.commands;

import com.lasat.common.data.Country;
import com.lasat.common.data.Person;
import com.lasat.server.exceptions.IncorrectArgumentException;
import com.lasat.server.exceptions.MissingArgumentException;

/**
 *A class that implements filtering of collection elements by the specified value of the nationality field. Outputs elements whose value of the nationality field is less than the specified one.
 */
public class FilterLessThanNationality extends Command {
    public FilterLessThanNationality() {
        super("filter_less_than_nationality", "nationality", "выводит элементы, значение поля nationality которых меньше заданного");
    }

    public String execute(CommandController controller, String[] args) {
        String str = "";
        if (controller.getDataController().getSortedMap().isEmpty()) {
            return "Коллекция пуста.";
        }
        Country country = Country.USA;
        for (Country i: Country.values()) {
            if (i.toString().equals(args[1].toUpperCase())) {
                country = i;
                break;
            }
        }
        for (Person i: controller.getDataController().getSortedMap().values()) {
            if (i.getNationality() == null) {
                str += i + "\n";
                continue;
            }
            if (i.getNationality().ordinal() < country.ordinal())
                str += i + "\n";
        }
        return str;
    }

    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {
        if (args.length > 2)
            throw new MissingArgumentException("должен присутствовать лишь один аргумент");
        if (args.length == 1)
            throw new MissingArgumentException("отсутствует аргумент nationality");
        Country country = null;
        for (Country i: Country.values()) {
            if (i.toString().equals(args[1].toUpperCase())) {
                country = i;
                break;
            }
        }
        if (country == null)
            throw new IncorrectArgumentException("данной национальности не существует");
    }
}
