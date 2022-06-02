package com.lasat.server.commands;

import com.lasat.server.db_utils.DBFiller;
import com.lasat.server.db_utils.DBManager;
import com.lasat.server.exceptions.IncorrectArgumentException;
import com.lasat.server.exceptions.MissingArgumentException;

/**
 * Sets the basic constructs of the command necessary for its implementation
 */
public interface Executable {
    String execute (CommandController controller, String[] args);
    void checkArgs (CommandController controller, String[] args) throws IncorrectArgumentException, MissingArgumentException;
}
