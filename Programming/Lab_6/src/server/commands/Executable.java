package server.commands;

import server.exceptions.IncorrectArgumentException;
import server.exceptions.MissingArgumentException;

/**
 * Sets the basic constructs of the command necessary for its implementation
 */
public interface Executable {
    String execute (CommandController controller, String[] args);

    void checkArgs (CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException;
}
