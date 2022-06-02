package com.lasat.client;

import com.lasat.common.Package;
import com.lasat.common.data.Country;
import com.lasat.common.data.Person;
import com.lasat.common.data.User;
import com.lasat.common.exceptions.IncorrectArgumentException;
import com.lasat.common.exceptions.MissingArgumentException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Validator implements Serializable {

    User user;
    Request request = new Request();

    public Validator (User user) {
        this.user = user;
    }

    public void checkArgs (Socket socket, String[] args) throws MissingArgumentException, IncorrectArgumentException, IOException, ClassNotFoundException {
        /*if (args[0].equals("insert")) {
            if (args.length > 2)
                throw new MissingArgumentException("у команды insert лишь один аргумент - id");
            if (args.length == 1)
                throw new MissingArgumentException("id - обязательный аргумент для insert");
            long id;
            try {
                id = Long.parseLong(args[1]);
            } catch (NumberFormatException e) {
                throw new IncorrectArgumentException("id должно быть целым числом");
            }
            if (!Person.checkUniqueId(getSortedMap(user, socket), id))
                throw new IncorrectArgumentException("id должен быть уникальным для этой коллекции");
        }*/

        if (args[0].equals("update")) {
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
            if (Person.checkUniqueId(getSortedMap(user, socket), Long.parseLong(args[1])))
                throw new IncorrectArgumentException("элемента с таким id не существует");
        }

        if (args[0].equals("execute_script")) {
            if (args.length == 1)
                throw new MissingArgumentException("отсутствует обязательный аргумент file_name");
            else if (args.length > 2)
                throw new MissingArgumentException("слишком много аргументов");
        }

        if (args[0].equals("filter_greater_than_height")) {

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

        if (args[0].equals("filter_less_than_nationality")) {
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

        if (args[0].equals("remove_key")) {
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
            if (!getSortedMap(user, socket).containsKey(id)) {
                throw new IncorrectArgumentException("человека с таким id в коллекции не существует");
            }
        }

        if (args[0].equals("remove_lower_key")) {
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

            if (args[0].equals("replace_if_lower")) {
                if (args.length > 2)
                    throw new MissingArgumentException("должен присутствовать лишь один аргумент");
                if (args.length == 1)
                    throw new MissingArgumentException("id {element} - обязательный аргумент для replace_if_lower");
                try {
                    if (Long.parseLong(args[1]) <= 0) {
                        throw new IncorrectArgumentException("значение id должно быть положительным");
                    }
                } catch (NumberFormatException e) {
                    throw new IncorrectArgumentException("значение должно являться целым числом");
                }
                if (Person.checkUniqueId(getSortedMap(user, socket), Long.parseLong(args[1])))
                    throw new IncorrectArgumentException("элемента с таким id не существует");
            }




        }
    }
    public SortedMap<Long, Person> getSortedMap (User user, Socket socket) throws IOException, ClassNotFoundException {
        Package pack = new Package(user, "sortedmap");
        request.request(pack, socket);
        Package inputPack = new Client().getPackage(socket, "sortedmap");
        /*byte[] bytes = new byte[32768];
        socket.getInputStream().read(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Package inputPack = (Package) objectInputStream.readObject();
         */
        return (inputPack.getSortedMap()) ;
    }
}
