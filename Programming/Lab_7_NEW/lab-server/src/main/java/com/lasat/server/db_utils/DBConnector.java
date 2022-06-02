package com.lasat.server.db_utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static final String LOGIN = "postgres"; //System.getenv("DB_LOGIN");
    private static final String PASSWORD = "1973"; //System.getenv("DB_PASS");
    private static final String HOST = "127.0.0.1"; //System.getenv("DB_HOST");
    private static final String NAME = "postgres"; //System.getenv("DB_NAME");
    private static final String DB_HOST = "jdbc:postgresql://" + HOST + ":5432/" + NAME;

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_HOST, LOGIN, PASSWORD);
    }
}