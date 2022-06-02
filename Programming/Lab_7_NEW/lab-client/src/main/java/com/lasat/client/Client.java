package com.lasat.client;

//import server.commands.CommandController;

import com.lasat.client.Initialization.Initialize;
import com.lasat.common.Package;

import com.lasat.common.data.Color;
import com.lasat.common.data.Country;
import com.lasat.common.data.Person;
import com.lasat.common.data.User;
import com.lasat.common.exceptions.IncorrectArgumentException;
import com.lasat.common.exceptions.MissingArgumentException;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    Request request = new Request();
    Scanner scanner = new Scanner(System.in);
    PersonEditor personEditor = new PersonEditor();
    static User user = new User();

    public void run(int port) throws UnknownHostException {
        Validator validator = new Validator(user);
        InetAddress address = Inet4Address.getByName("localhost");
        try {
            Socket socket = new Socket(address, port);
            user = Initialize.init(socket, request);
            while (true) {
                System.out.print("$ ");
                String str = scanner.nextLine().toLowerCase();
                String[] args = str.split(" ");
                if (str.equals("insert")) {
                    Person person = personEditor.createPerson(args, user);
                    Package pack = new Package(user, args[0], person);
                    request.request(pack, socket);
                    Package getPack = getPackage(socket, args[0]);
                    System.out.println(getPack.getAnswer());
                } else if (str.startsWith("execute")) {
                    try {
                        validator.checkArgs(socket, args);
                        executeScript(args, validator, socket);
                        continue;
                    } catch (MissingArgumentException | IncorrectArgumentException e) {
                        System.out.println("Отсутствуют нужные аргументы: " + e.getMessage() + ".");
                        continue;
                    }
                } else if (str.equals("exit")) {
                    System.out.println("Прерывание работы программы...");
                    System.exit(0);
                } else if (str.startsWith("update")) {
                    try {
                        validator.checkArgs(socket, args);
                        Person person = personEditor.updatePerson(validator.getSortedMap(user, socket).get(Long.parseLong(args[1])));
                        Package pack = new Package(user, args[0], person);
                        request.request(pack, socket);
                        Package getPack = getPackage(socket, args[0]);
                        System.out.println(getPack.getAnswer());
                    } catch (MissingArgumentException e) {
                        System.out.println("Отсутствуют нужные аргументы: " + e.getMessage() + ".");
                        continue;
                    } catch (IncorrectArgumentException e) {
                        System.out.println("Некорректные аргументы команды: " + e.getMessage() + ".");
                        continue;
                    }
                } else if (str.startsWith("replace_if_lower")) {
                    try {
                        validator.checkArgs(socket, args);
                        Person person = replaceIfLower(socket, args);
                        Package pack = new Package(user, args[0], person);
                        request.request(pack, socket);
                        Package getPack = getPackage(socket, args[0]);
                        System.out.println(getPack.getAnswer());
                    } catch (MissingArgumentException e) {
                        System.out.println("Отсутствуют нужные аргументы: " + e.getMessage() + ".");
                        continue;
                    } catch (IncorrectArgumentException e) {
                        System.out.println("Некорректные аргументы команды: " + e.getMessage() + ".");
                        continue;
                    }
                } else if (str.equals("show")) {
                    Package pack = new Package(user, args[0]);
                    request.request(pack, socket);
                    Package getPack = getPackage(socket, args[0]);
                    System.out.println(getPack.getSortedMap().values());
                } else if (str.equals("clear")) {
                    Package pack = new Package(user, args[0], args);
                    request.request(pack, socket);
                    Package getPack = getPackage(socket, args[0]);
                    System.out.println(getPack.getAnswer());
                } else if (str.startsWith("filter_greater_than_height") ||
                        str.startsWith("filter_less_than_nationality") || str.startsWith("remove_key") ||
                        str.startsWith("remove_lower_key")) {
                    try {
                        validator.checkArgs(socket, args);
                        Package pack = new Package(user, args[0], args);
                        request.request(pack, socket);
                        Package getPack = getPackage(socket, args[0]);
                        System.out.println(getPack.getAnswer());
                    } catch (MissingArgumentException e) {
                        System.out.println("Отсутствуют нужные аргументы: " + e.getMessage() + ".");
                        continue;
                    } catch (IncorrectArgumentException e) {
                        System.out.println("Некорректные аргументы команды: " + e.getMessage() + ".");
                        continue;
                    }
                } else if (str.startsWith("help") || str.startsWith("info") ||
                        str.startsWith("history") || str.startsWith("save") || str.startsWith("print_field_descending_weight")) {
                    Package pack = new Package(user, args[0], args);
                    request.request(pack, socket);
                    Package getPack = getPackage(socket, args[0]);
                    System.out.println(getPack.getAnswer());
                } else {
                    System.out.println("Неверно введена команда, повторите ввод.");
                    continue;
                }
                /*
                byte[] bytes = new byte[32768];
                socket.getInputStream().read(bytes);
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
                Package outPack = (Package) objectInputStream.readObject();
                System.out.println(outPack.getAnswer());
                */

            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
            System.out.println("Подключение к серверу не удалось");
        }


    }
    public Package getPackage (Socket socket, String name) throws IOException, ClassNotFoundException {
        byte[] bytes = new byte[32768];
        socket.getInputStream().read(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Package outPack = (Package) objectInputStream.readObject();
        if (name.equals(outPack.getName())) {
            return outPack;
        } else {
            return getPackage(socket, name);
        }
    }

    private Person getPerson (Socket socket) throws IOException, ClassNotFoundException {
        Package receivePerson = new Package(user, "getperson");
        request.request(receivePerson, socket);
        byte[] bytes = new byte[32768];
        socket.getInputStream().read(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Package outPack = (Package) objectInputStream.readObject();
        return outPack.getPerson();
    }

    private void executeScript(String[] args, Validator validator, Socket socket) throws MissingArgumentException, IOException, ClassNotFoundException, IncorrectArgumentException {
        int recursionDepth = 1;
        final int MAX_RECURSION_DEPTH = 3;
        if (args.length == 1)
            throw new MissingArgumentException("отсутствует обязательный аргумент file_name");
        else if (args.length > 2)
            throw new MissingArgumentException("слишком много аргументов");
        System.out.println("Считываем файл...");
        try {
            Scanner scanner = new Scanner(new FileInputStream(args[1]));
            while (scanner.hasNextLine()) {
                String[] command = scanner.nextLine().split(" ");
                if (command[0].equals("execute_script")) {
                    if (args[1].equals(command[1])) {
                        if (recursionDepth == MAX_RECURSION_DEPTH) {
                            recursionDepth = 1;
                            System.out.println("Глубина рекурсии превысила максимальную (" + MAX_RECURSION_DEPTH + "). Рекурсия была прервана.");
                        } else
                            recursionDepth++;
                    }
                }
                validator.checkArgs(socket, command);
                Package pack = new Package(user, command[0], command);
                request.request(pack, socket);
                byte[] bytes = new byte[32768];
                socket.getInputStream().read(bytes);
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
                Package inputPack = (Package) objectInputStream.readObject();
                System.out.println(inputPack.getAnswer());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Неверный аргумент: данный файл не найден.");
        }
    }

    private Person replaceIfLower (Socket socket, String[] args) throws IOException, ClassNotFoundException {
        Person person = getPerson(socket);
        Person newPerson = new Person(personEditor.updatePerson(person));
        if (newPerson.getName().compareTo(person.getName()) > 0)
            newPerson.setName(person.getName());
        if (newPerson.getCoordinates().getX() > person.getCoordinates().getX())
            newPerson.getCoordinates().setX(person.getCoordinates().getX());
        if (newPerson.getCoordinates().getY() > person.getCoordinates().getY())
            newPerson.getCoordinates().setY(person.getCoordinates().getY());
        if (newPerson.getHeight() > person.getHeight())
            newPerson.setHeight(person.getHeight());
        if (person.getWeight() == null)
            newPerson.setWeight(null);
        else if (newPerson.getWeight() == null);
        else if (newPerson.getWeight() > person.getWeight())
            newPerson.setWeight(person.getWeight());
        if (person.getHairColor() == null)
            newPerson.setHairColor((Color) null);
        else if (newPerson.getHairColor() == null);
        else if (newPerson.getHairColor().ordinal() > person.getHairColor().ordinal())
            newPerson.setHairColor(person.getHairColor());
        if (person.getNationality() == null)
            newPerson.setNationality((Country) null);
        else if (newPerson.getNationality() == null);
        else if (newPerson.getNationality().ordinal() > person.getNationality().ordinal())
            newPerson.setNationality(person.getNationality());
        if (newPerson.getLocation().getX() > person.getLocation().getX())
            newPerson.getLocation().setX(person.getLocation().getX());
        if (newPerson.getLocation().getY() > person.getLocation().getY())
            newPerson.getLocation().setY(person.getLocation().getY());
        if (newPerson.getLocation().getZ() > person.getLocation().getZ())
            newPerson.getLocation().setZ(person.getLocation().getZ());

        return newPerson;
    }

}
