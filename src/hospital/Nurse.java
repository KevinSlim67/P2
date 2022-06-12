package hospital;

import db.SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Nurse extends Person implements SQL {

    private int id;
    private String department;

    public Nurse(String name, int age, int id, String department) {
        super(name, age);
        this.id = id;
        this.department = department;
    }

    //inserts into table 'Nurse'
    @Override
    public void insert(Connection c) throws SQLException {
        setStatement(c.createStatement());
        String query = "INSERT INTO Nurse (id, name, age, department)" +
                " VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStmt = c.prepareStatement(query);
        preparedStmt.setInt (1, this.id);
        preparedStmt.setString (2, super.getName());
        preparedStmt.setInt (3, super.getAge());
        preparedStmt.setString (4, this.department);
        preparedStmt.execute();

        System.out.println("Nurse " + super.getName() + " added to table 'Nurse'");
    }

    //returns all rows in table 'Nurse'
    public static List<String> returnAll(Connection c) throws SQLException {
        List<String> list = new ArrayList<String>();
        setStatement(c.createStatement());

        String query = "SELECT * FROM Nurse";
        ResultSet rs = getStatement().executeQuery(query);
        String id, name, age, department;

        while (rs.next()) {
            id = "id: " + rs.getString("id");
            name = ", name: " + rs.getString("name");
            age = ", age: " + rs.getString("age");
            department = ", department: " + rs.getString("department");


            list.add(id + name + age + department);
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

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
