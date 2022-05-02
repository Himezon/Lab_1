package client;

//import server.commands.CommandController;
import common.exceptions.MissingArgumentException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

import javax.swing.*;

public class Client {
    void run (int port) throws UnknownHostException {
        InetAddress address = Inet4Address.getByName("localhost");
        Request request = new Request();

        try {
            Scanner scanner = new Scanner(System.in);
            Socket socket = new Socket(address, port);
            while (true) {
                String str = scanner.nextLine();
                Object obj;
                if (str.startsWith("i")) {
                    //request.request(commandController.getDataController().getConsoleController().createPerson(), socket); //----
                } else if (str.startsWith("e")) {
                    //commandController.invoke(commandController.parseCommand("execute_script"), str.split(" ")); //----
                    continue;
                } else {
                    obj = str.split(" ");
                    request.request(obj, socket);
                }
                byte[] bytes = new byte[32768];
                socket.getInputStream().read(bytes);
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
                System.out.println("hi " + objectInputStream.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void executeScript (String[] args) throws MissingArgumentException {
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
                            System.out.println("Глубина рекурсии превысила максимальную ("+MAX_RECURSION_DEPTH+"). Рекурсия была прервана.");
                        }
                        else
                            recursionDepth++;
                    }
                }
                //////////////
            }
        } catch (FileNotFoundException e) {
            System.out.println("Неверный аргумент: данный файл не найден.");
        }
    }

}
