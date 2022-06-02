package com.lasat.client.Initialization;

import com.lasat.common.data.User;

import java.util.Locale;
import java.util.Scanner;

public class Auth {
    private static Scanner scanner = new Scanner(System.in);

    private static final short MIN_PASSWORD_LENGTH = 4;
    private static final short MAX_PASSWORD_LENGTH = 20;
    private static final short MAX_LOGIN_LENGTH = 20;

    public static User authorize () {
            System.out.println("/System/: Введите \"exit\", если Вы хотите прервать авторизацию");
            System.out.println("/System/: Введите логин:");
            String login = Auth.login();
            System.out.println("/"+login+"/: Введите пароль:");
            String password = Auth.password();
            return new User(login, password);
    }


    private static String password () {
        String[] password = scanner.nextLine().toLowerCase().split(" ");
        if (password.length == 0) {
            System.out.println("Пароль не может быть пустым. Повторите ввод: ");
            Auth.password();
        }
        exitFromAuth(password);
        if (password.length > 1) {
            System.out.println("Пароль не может содержать пробелы. Повторите ввод: ");
            Auth.password();
        }
        if (password[0].length() > MAX_PASSWORD_LENGTH) {
            System.out.println("Пароль должен содержать менее " + MAX_PASSWORD_LENGTH + " символов.");
            Auth.password();
        }
        if (password[0].length() < MIN_PASSWORD_LENGTH) {
            System.out.println("Пароль не может содержать менее " + MIN_PASSWORD_LENGTH + " символов. Повторите ввод: ");
            Auth.password();
        }
        return password[0];
    }

    private static String login() {
        String[] login = scanner.nextLine().toLowerCase().split(" ");
        if (login.length == 0) {
            System.out.println("Логин не может быть пустым. Повторите ввод: ");
            Auth.login();
        }
        exitFromAuth(login);
        if (login.length > 1) {
            System.out.println("Логин не может содержать пробелы. Повторите ввод: ");
            Auth.login();
        }
        if (login[0].length() < 1) {
            System.out.println("Логин не может содержать менее одного символа. Повторите ввод: ");
            Auth.login();
        }
        if (login[0].length() > MAX_LOGIN_LENGTH) {
            System.out.println("Логин должен содержать менее " + MAX_LOGIN_LENGTH + " символов.");
            Auth.login();
        }
        return login[0];
    }

    private static void exitFromAuth(String[] login) {
        if (login[0].equals("exit")) {
            System.out.println("Авторизация не выполнена. Желаете зарегистрировать новго пользователя?");
            System.out.println("Введите \"да\", если желаете и \"нет\", если хотите прервать работу клиента");
            String[] mean = scanner.nextLine().toLowerCase(Locale.ROOT).split("");
            if (mean[0].startsWith("да")) {
                Reg.registration();
            } else {
                System.exit(0);
            }
        }
    }
}
