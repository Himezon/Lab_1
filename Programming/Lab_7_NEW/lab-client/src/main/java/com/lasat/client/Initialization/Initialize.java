package com.lasat.client.Initialization;

import com.lasat.client.Request;
import com.lasat.common.Package;
import com.lasat.common.data.User;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Initialize {

    static Scanner scanner = new Scanner(System.in);

    public static User init(Socket socket, Request request) {
        System.out.println("/System/: Введите \"auth\" если Вы хотите авторизоваться в системе");
        System.out.println("/System/: Введите \"reg\" если Вы хотите зарегистрироваться в системе:");
        String str = scanner.nextLine().toLowerCase();
        if (str.trim().startsWith("auth")) {
            User user = Auth.authorize();
            try {
                Package pack = new Package(user, "checker");
                request.request(pack, socket);
                boolean result = getResultOfSendingPerson(socket);
                if (!result) {
                    System.out.println("Неправильные учетные данные.");
                    init(socket, request);
                }
                return user;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else if (str.trim().startsWith("reg")) {
            User user = Reg.registration();
            try {
                Package pack = new Package(user, "adduser");
                request.request(pack, socket);
                boolean result = getResultOfSendingPerson(socket);
                if (!result) {
                    System.out.println("Не удалось создать пользователя, этот логин уже занят.");
                    init(socket, request);
                }
                return user;
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            init(socket, request);
        }
        return null;
    }

    private static boolean getResultOfSendingPerson(Socket socket) throws IOException, ClassNotFoundException {
        byte[] bytes = new byte[32768];
        socket.getInputStream().read(bytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Package outPack = (Package) objectInputStream.readObject();
        return outPack.getCheckedID();
    }
}
