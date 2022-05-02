package server.commands;

import server.exceptions.IncorrectArgumentException;
import server.exceptions.MissingArgumentException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A class that implements reading and executing commands from a specified file
 */
public class ExecuteScriptCommand extends Command {
    private int recursionDepth = 1;
    public static final int MAX_RECURSION_DEPTH = 3;
    public ExecuteScriptCommand() {
        super("execute_script", "file_name", "считывает и исполняет скрипт из указанного файла");
    }

    public String execute(CommandController controller, String[] args) {
        String retString = "";
        retString += "Считываем файл...\n";
        try {
            Scanner scanner = new Scanner(new FileInputStream(args[1]));
            while (scanner.hasNextLine()) {
                String[] command = scanner.nextLine().split(" ");
                if (controller.parseCommand(command[0]).getName().equals("execute_script")) {
                    if (args[1].equals(command[1])) {
                        if (recursionDepth == MAX_RECURSION_DEPTH) {
                            recursionDepth = 1;
                            retString += "Глубина рекурсии превысила максимальную ("+MAX_RECURSION_DEPTH+"). Рекурсия была прервана.\n";
                        }
                        else
                            recursionDepth++;
                    }
                }
                controller.invoke(controller.parseCommand(command[0]), command);
            }
        } catch (FileNotFoundException e) {
            return retString + "Неверный аргумент: данный файл не найден.\n";
        }
        return retString;

    }

    public void checkArgs(CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException {
        if (args.length == 1)
            throw new MissingArgumentException("отсутствует обязательный аргумент file_name");
        else if (args.length > 2)
            throw new MissingArgumentException("слишком много аргументов");
    }

    public int getRecursionDepth() {
        return recursionDepth;
    }
}
