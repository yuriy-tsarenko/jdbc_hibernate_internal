package com.jdbc_hibernate_internal.lesson2.demo_app.db_connector;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.jdbc_hibernate_internal.lesson2.demo_app.util.Constants.BASE_URL;
import static com.jdbc_hibernate_internal.lesson2.demo_app.util.Constants.DB_NAME;
import static com.jdbc_hibernate_internal.lesson2.demo_app.util.Constants.LOGIN;
import static com.jdbc_hibernate_internal.lesson2.demo_app.util.Constants.PASSWORD;
import static com.jdbc_hibernate_internal.lesson2.demo_app.util.Constants.TIMEZONE;
import static com.jdbc_hibernate_internal.lesson2.demo_app.util.Constants.USE_LEGACY_DT_CODE;


public class DataBaseConnector {

    private static Connection connection;
    private static Statement statement;

    private DataBaseConnector() {
    }

    private static String createURL() {
        return BASE_URL
                + "/"
                + DB_NAME
                + "?"
                + "useLegacyDatetimeCode=" + USE_LEGACY_DT_CODE
                + "&"
                + "serverTimezone=" + TIMEZONE;
    }

    public static Statement createConnection() throws SQLException {
        connection = DriverManager.getConnection(createURL(), LOGIN, PASSWORD);
        statement = connection.createStatement();
        return statement;
    }

    public static void closeConnection() throws SQLException {
        connection.close();
        statement.close();
    }
}
