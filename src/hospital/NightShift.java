package hospital;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NightShift extends Nurse implements Hospital {

    private String date;
    private String time;

    public NightShift(String name, int age, int id, String department, String date, String time) {
        super(name, age, id, department);
        this.date = date;
        this.time = time;
    }

    //inserts into table 'Shift'
    @Override
    public void insert(Connection c) throws SQLException {
        super.insert(c);

        String query = "INSERT INTO Shift (nurse_id, date, time, shift)" +
                " VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStmt = c.prepareStatement(query);
        preparedStmt.setInt (1, this.getId());
        preparedStmt.setString (2, this.date);
        preparedStmt.setString (3, this.time);
        preparedStmt.setString (4, "night");
        preparedStmt.execute();

        System.out.println("Nurse '" + super.getId() +  "' with Night Shift added to table 'Shift'");
    }

    //inserts existing nurse into table 'Shift'
    public void insertExisting(Connection c) throws SQLException {
        setStatement(c.createStatement());

        String query = "INSERT INTO Shift (nurse_id, date, time, shift)" +
                " VALUES (?, ?, ?, ?)";

        List<String> records = super.returnAll(c);
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).contains("id: " + this.getId() + ",")) {
                PreparedStatement preparedStmt = c.prepareStatement(query);
                preparedStmt.setInt (1, this.getId());
                preparedStmt.setString (2, this.date);
                preparedStmt.setString (3, this.time);
                preparedStmt.setString (4, "night");
                preparedStmt.execute();

                System.out.println("Nurse " + super.getId() +  "' with Night Shift added to table 'Shift'");
                return;
            }
        }
        System.out.println("Did not find a record in the database with this ID!");
    }

    //returns all rows where shift = 'day' in table 'Shift'
    public static List<String> returnAll(Connection c) throws SQLException {
        List<String> list = new ArrayList<String>();
        setStatement(c.createStatement());

        String query = "SELECT * FROM Shift WHERE shift = 'night'";
        ResultSet rs = getStatement().executeQuery(query);
        String id, date, time, shift;

        while (rs.next()) {
            id = "id: " + rs.getString("nurse_id");
            date = ", date: " + rs.getString("date");
            time = ", time: " + rs.getString("time");
            shift = ", shift: " + rs.getString("shift");


            list.add(id + date + time + shift);
        }
        return list;
    }

    @Override
    public void delete(Connection c) throws SQLException {
        setStatement(c.createStatement());
        String query = "DELETE FROM Shift WHERE nurse_id = " + this.getId() + " AND shift = 'night'";

        PreparedStatement preparedStmt = c.prepareStatement(query);
        preparedStmt.execute();

        System.out.println("Nurse " + this.getId() + " with Night Shift deleted from table 'Patient'");
    }

    @Override
    public String getMedication() {
        return null;
    }
}
