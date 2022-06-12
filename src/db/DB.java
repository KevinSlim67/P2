package db;

import hospital.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.List;


public class DB {
    public static Connection connection;

    public static void main(String[] args) throws SQLException {
        connection = connectToDatabase();
        closeConnection();
    }

    static public Connection connectToDatabase() {
        try {
            return DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/hospital", "root", Password.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    static public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //this is a generic method that will work on all types of lists
    static <G> void printList(List<G> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
