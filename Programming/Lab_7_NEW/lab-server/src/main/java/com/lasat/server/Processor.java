package com.lasat.server;

import com.lasat.common.Package;
import com.lasat.common.db_utils.DBWorker;
import com.lasat.server.commands.CommandController;
import com.lasat.server.db_utils.DBConnector;
import com.lasat.server.db_utils.DBFiller;
import com.lasat.server.db_utils.DBManager;
import com.lasat.server.utils.Encryptor;
import com.lasat.server.utils.MD2Encryptor;

import java.nio.channels.SocketChannel;

public class Processor {

    CommandController commandController;
    SocketChannel client;
    DBConnector dbConnector = new DBConnector();
    Encryptor encryptor = new MD2Encryptor();
    DBFiller dbFiller = new DBFiller();
    DBManager dbManager = new DBManager();
    public Processor (CommandController commandController, SocketChannel client) {
        this.commandController = commandController;
        this.client = client;
    }

    public void process (Package inputPack) {
        String[] command = inputPack.getArgs();

        if (inputPack.getName().equals("checker")) {
            Package outputPack = new Package(inputPack.getUser(), inputPack.getName(), dbManager.checkIfUserRegistered(inputPack.getUser().getLogin(), inputPack.getUser().getPassword()));
            new Thread(new Writer(client, outputPack)).start();
        } else if (inputPack.getName().equals("adduser")) {
            Package outputPack = new Package(inputPack.getUser(), inputPack.getName(), dbManager.registerNewUser(inputPack.getUser().getLogin(), inputPack.getUser().getPassword()));
            new Thread(new Writer(client, outputPack)).start();
        } else if (inputPack.getName().equals("sortedmap")) {
            Package outputPack = new Package(inputPack.getUser(), inputPack.getName(), dbFiller.getSortedMapPersons());
            new Thread(new Writer(client, outputPack)).start();
        } else if (inputPack.getName().equals("insert")) {
            commandController.getDataController().addPerson(inputPack.getPerson());
            long result = dbManager.addPersonToDB(inputPack.getPerson());
            Package outputPack;
            if (result <= 0) {
                outputPack = new Package(inputPack.getUser(), inputPack.getName(), "Невозможно добавить элемент Person");
            } else {
                outputPack = new Package(inputPack.getUser(), inputPack.getName(), "Элемент коллекции успешно добавлен с id" + result);
            }
            new Thread(new Writer(client, outputPack)).start();
        } else if (inputPack.getName().equals("update")) {
            commandController.getDataController().addPerson(inputPack.getPerson());
            long result = dbManager.updateByIdAndUser(inputPack.getPerson(), inputPack.getPerson().getId(), inputPack.getUser().getLogin());
            Package outputPack;
            if (result <= 0) {
                outputPack = new Package(inputPack.getUser(), inputPack.getName(), "Элемент коллекции обновить не удалось");
            } else {
                outputPack = new Package(inputPack.getUser(), inputPack.getName(), "Элемент коллекции успешно обновлён");
            }
            new Thread(new Writer(client, outputPack)).start();
        } else if (inputPack.getName().equals("replace_if_lower")) {
            commandController.getDataController().addPerson(inputPack.getPerson());
            long result = dbManager.updateByIdAndUser(inputPack.getPerson(), inputPack.getPerson().getId(), inputPack.getUser().getLogin());
            Package outputPack;
            if (result <= 0) {
                outputPack = new Package(inputPack.getUser(), inputPack.getName(), "Заменить значения не удалось");
            } else {
                outputPack = new Package(inputPack.getUser(), inputPack.getName(), "Замена значений успешно выполнена");
            }
            new Thread(new Writer(client, outputPack)).start();
        } else if (inputPack.getName().equals("show")) {
            Package outputPack = new Package(inputPack.getUser(), inputPack.getName(), dbFiller.getSortedMapPersons());
            new Thread(new Writer(client, outputPack)).start();
        } else if (inputPack.getName().equals("clear")) {
            Package outputPack = new Package(inputPack.getUser(), inputPack.getName(), "Было удалено " +
                    dbManager.clearByUserName(inputPack.getUser().getLogin()).length + " элементов");
            new Thread(new Writer(client, outputPack)).start();
        } else {
            Package outputPack = new Package(inputPack.getUser(), inputPack.getName(), commandController.invoke(commandController.parseCommand(command[0]), command));
            new Thread(new Writer(client, outputPack)).start();
        }

    }


}
