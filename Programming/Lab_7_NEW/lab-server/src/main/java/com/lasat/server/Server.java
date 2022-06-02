package com.lasat.server;

import com.lasat.common.data.Person;
import com.lasat.common.db_utils.DBWorker;
import com.lasat.server.db_utils.DBConnector;
import com.lasat.server.db_utils.DBManager;
import com.lasat.server.db_utils.DBFiller;
import com.lasat.server.utils.Encryptor;
import com.lasat.server.utils.MD2Encryptor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.SortedMap;

public class Server {

    private String file;
    Server (String file) { this.file = file; }

/*
    if (personSet != null) {
        CollectionManager collectionManager = new CollectionManagerImpl(personSet);
        PerformanceState performanceState = new PerformanceState();
        CommandManager commandManager = new CommandManager(collectionManager, dbWorker, performanceState);
        RequestExecutor requestExecutor = new RequestExecutor(commandManager);
        try {
            ConnectionHandler connectionHandler = new ConnectionHandler(requestExecutor, performanceState);
            new Thread(new CommandListener(commandManager, false)).start();
            connectionHandler.run();
        } catch (IOException e) {
            System.out.print("");
        }
    }
*/

    public void run (int port) {
        DBConnector dbConnector = new DBConnector();
        DBManager dbManager = new DBManager();
        dbManager.init();

        Encryptor encryptor = new MD2Encryptor();
        DBFiller dbFiller = new DBFiller();
        SortedMap<Long, Person> personSortedMap = dbFiller.getSortedMapPersons();
        //System.out.println(personSortedMap);
        if (personSortedMap != null) {
            try {
                ServerSocketChannel serverSocket = ServerSocketChannel.open();
                serverSocket.bind(new InetSocketAddress(port));
                serverSocket.configureBlocking(false);
                ClientReader.reader(serverSocket, file);
            } catch (IOException e) {
                System.out.print("");
            }
        }


    }
}
    /*
     *
     *
     * Переписать commandManager (мой commandController) для взаимодействия с DataBase
     *
     *
     */

