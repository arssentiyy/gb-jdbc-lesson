package ru.gb;
import java.sql.*;

public class JdbcApp {
    private Connection connection;
    private Statement statement;

    public static void main(String[] args) {
        final JdbcApp JdbcApp = new JdbcApp();
        try {
            JdbcApp.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcApp.disconnect();
        }
    }
    private void createTable(){

    }
    private void disconnect() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void connect() throws SQLException {
        connection=DriverManager.getConnection("jdbc:sqlite:javadb.db");
        statement = connection.createStatement();

    }

}
