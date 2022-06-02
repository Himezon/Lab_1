package com.lasat.server;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServerMain {
    public static void main (String[] args) {
        String file = "test.csv";
        Server server = new Server(file);
        server.run(19735);
    }
}
