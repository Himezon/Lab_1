package com.lasat.client.Initialization;

import com.lasat.common.data.User;

import java.util.Locale;
import java.util.Scanner;

public class Reg {

    private static Scanner scanner = new Scanner(System.in);

    private static final short MIN_PASSWORD_LENGTH = 4;
    private static final short MAX_PASSWORD_LENGTH = 20;
    private static final short MAX_LOGIN_LENGTH = 20;

    public static User registration() {
        System.out.println("/System/: Введите \"exit\", если Вы хотите прервать регистрацию");
        System.out.println("/System/: Введите логин:");
        String login = Reg.login();
        System.out.println("/"+login+"/: Введите пароль:");
        String password = Reg.password();
        return new User(login, password);
    }

    private static String password () {
        String[] password = scanner.nextLine().toLowerCase().split(" ");
        if (password.length == 0) {
            System.out.println("Пароль не может быть пустым. Повторите ввод: ");
            Reg.password();
        }
        exitFromReg(password);
        if (password.length > 1) {
            System.out.println("Пароль не может содержать пробелы. Повторите ввод: ");
            Reg.password();
        }
        if (password[0].length() > MAX_PASSWORD_LENGTH) {
            System.out.println("Пароль должен содержать менее " + MAX_PASSWORD_LENGTH + " символов.");
            Reg.password();
        }
        if (password[0].length() < MIN_PASSWORD_LENGTH) {
            System.out.println("Пароль не может содержать менее " + MIN_PASSWORD_LENGTH + " символов. Повторите ввод: ");
            Reg.password();
        }
        return password[0];
    }

    private static String login() {
        String[] login = scanner.nextLine().toLowerCase().split(" ");
        if (login.length == 0) {
            System.out.println("Логин не может быть пустым. Повторите ввод: ");
            Reg.login();
        }
        exitFromReg(login);
        if (login.length > 1) {
            System.out.println("Логин не может содержать пробелы. Повторите ввод: ");
            Reg.login();
        }
        if (login[0].length() < 1) {
            System.out.println("Логин не может содержать менее одного символа. Повторите ввод: ");
            Reg.login();
        }
        if (login[0].length() > MAX_LOGIN_LENGTH) {
            System.out.println("Логин должен содержать менее " + MAX_LOGIN_LENGTH + " символов.");
            Reg.login();
        }
        return login[0];
    }

    private static void exitFromReg(String[] login) {
        if (login[0].equals("exit")) {
            System.out.println("Регистрация не выполнена. Желаете авторизоваться?");
            System.out.println("Введите \"да\", если желаете авторизоваться или \"нет\", если хотите прервать работу клиента");
            String[] mean = scanner.nextLine().toLowerCase().split("");
            if (mean[0].startsWith("да")) {
                Auth.authorize();
            } else {
                System.exit(0);
            }
        }
    }
}
