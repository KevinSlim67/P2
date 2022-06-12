package hospital;

import db.SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person implements SQL {

    private int id;
    private String spec;

    public Doctor(String name, int age, int id, String spec) {
        super(name, age);
        this.id = id;
        this.spec = spec;
    }

    //inserts into table 'Doctor'
    @Override
    public void insert(Connection c) throws SQLException {
        setStatement(c.createStatement());
        String query = "INSERT INTO Doctor (id, name, age, spec)" +
                " VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStmt = c.prepareStatement(query);
        preparedStmt.setInt (1, this.id);
        preparedStmt.setString (2, super.getName());
        preparedStmt.setInt (3, super.getAge());
        preparedStmt.setString (4, this.spec);
        preparedStmt.execute();

        System.out.println("Doctor " + this.getId() + " added to table 'Doctor'");
    }

    //returns all rows in table 'Doctor'
    public static List<String> returnAll(Connection c) throws SQLException {
        List<String> list = new ArrayList<String>();
        setStatement(c.createStatement());

        String query = "SELECT * FROM Doctor";
        ResultSet rs = getStatement().executeQuery(query);
        String id, name, age, spec;

        while (rs.next()) {
            id = "id: " + rs.getString("id");
            name = ", name: " + rs.getString("name");
            age = ", age: " + rs.getString("age");
            spec = ", specialisation: " + rs.getString("spec");


            list.add(id + name + age + spec);
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

    public int getId() {
        return id;
    }
}
