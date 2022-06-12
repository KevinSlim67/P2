package hospital;

import db.SQL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Person implements SQL {

    private int id;
    private String date;
    private String time;

    public Patient(String name, int age, int id, String date, String time) {
        super(name, age);
        this.date = date;
        this.time = time;
        this.id = id;
    }

    public void print() {
        System.out.println("ID : " + id);
        System.out.println("Date : " + date);
        System.out.println("Time : " + time);
    }

    //inserts into table 'Patient'
    @Override
    public void insert(Connection c) throws SQLException {
        setStatement(c.createStatement());
        String query = "INSERT INTO Patient (id, name, age, date, time)" +
                " VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt = c.prepareStatement(query);
        preparedStmt.setInt (1, this.id);
        preparedStmt.setString (2, super.getName());
        preparedStmt.setInt (3, super.getAge());
        preparedStmt.setString (4, this.date);
        preparedStmt.setString (5, this.time);
        preparedStmt.execute();

        System.out.println("Patient " + this.getId() + " added to table 'Patient'");
    }

    //returns all rows in table 'Patient'
    public static List<String> returnAll(Connection c) throws SQLException {
        List<String> list = new ArrayList<String>();
        setStatement(c.createStatement());

        String query = "SELECT * FROM Patient";
        ResultSet rs = getStatement().executeQuery(query);
        String id, name, age, date, time;

        while (rs.next()) {
            id = "id: " + rs.getString("id");
            name = ", name: " + rs.getString("name");
            age = ", age: " + rs.getString("age");
            date = ", date: " + rs.getString("date");
            time = ", time: " + rs.getString("time");

            list.add(id + name + age + date + time);
        }
        return list;
    }

    //searches if a record with this current id exists in the associated table
    public boolean searchTable(Connection c) throws SQLException {
        setStatement(c.createStatement());

        List<String> list = returnAll(c);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains("id: " + this.getId() + ",")) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void delete(Connection c) throws SQLException {
        setStatement(c.createStatement());
        String query = "DELETE FROM Patient WHERE id = " + this.getId();

        PreparedStatement preparedStmt = c.prepareStatement(query);
        preparedStmt.execute();

        System.out.println("Patient " + this.getId() + " deleted from table 'Patient'");
    }

    public int getId() {
        return id;
    }
}
