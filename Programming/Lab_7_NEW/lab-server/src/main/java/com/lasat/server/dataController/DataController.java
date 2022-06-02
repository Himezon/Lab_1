package com.lasat.server.dataController;

import com.lasat.common.data.Person;
import com.lasat.common.data.User;
import com.lasat.server.db_utils.DBFiller;
import com.lasat.server.db_utils.DBManager;
import sun.reflect.generics.tree.Tree;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * A class that implements the SortedMap collection
 */
public class DataController {
    private SortedMap<Long, Person> sortedMap = new TreeMap<>();
    private final ConsoleController consoleController;
    private final FileController fileController;
    private final String path;
    private final DBManager dbManager = new DBManager();
    private final DBFiller dbFiller = new DBFiller();

    public DataController (final String path) {
        this.path = path;
        consoleController = new ConsoleController(this);
        fileController = new FileController(this, path);
        fileController.readCSVFile(path);
    }

    public String getPath() {
        return path;
    }


    public DBFiller getDbFiller() { return dbFiller; }
    public DBManager getDBManager() { return dbManager; }
    public SortedMap<Long, Person> getSortedMap() {
        return sortedMap;
    }
    public void addPerson (final Person person) {
        sortedMap.put(person.getId(), person);
    }
    public ConsoleController getConsoleController() {
        return consoleController;
    }
    public void setSortedMap (SortedMap<Long, Person> sortedMap) {
        this.sortedMap = sortedMap;
    }
    public FileController getFileController() {
        return fileController;
    }
}
