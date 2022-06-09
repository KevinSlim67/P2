package hospital;

import db.DB;
import db.SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Person implements SQL{
    private String name;
    private int age;
    private static Statement statement;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }

    //inserts current instance of Person to table 'Person'
    public void insert(Connection c) throws SQLException {
        createStatement();
        String query = "INSERT INTO person (name, age) VALUES (?, ?)";

        PreparedStatement preparedStmt = c.prepareStatement(query);
        preparedStmt.setString (1, this.name);
        preparedStmt.setInt (2, this.age);

        preparedStmt.execute();
        System.out.println("Person '" + this.name +"' added to table 'Person'");
    }

    //returns all rows in table 'Person'
    public static List<String> returnAll() throws SQLException {
        List<String> list = new ArrayList<String>();
        createStatement();

        String query = "SELECT * FROM Person";
        ResultSet rs = statement.executeQuery(query);
        String id, name, age;

        while (rs.next()) {
            id = "id: " + rs.getString("id");
            name = ", name: " + rs.getString("name");
            age = ", age: " + rs.getString("age");

            list.add(id + name + age);
        }
        return list;
    }

    //creates a statement that lets us make SQL queries
    public static void createStatement() {
        try {
            statement = DB.connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static Statement getStatement() {
        return statement;
    }
}
