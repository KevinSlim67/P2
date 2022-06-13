package hospital;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SurgeryP extends Patient implements Hospital {
    String surgeryType;

    public SurgeryP(String name, int age, int id, String date, String time, String surgeryType) {
        super(name, age, id, date, time);
        this.surgeryType =  surgeryType;
    }

    //inserts into table 'SurgeryP'
    @Override
    public void insert(Connection c) throws SQLException {
        super.insert(c);

        String query = "INSERT INTO SurgeryP (surgery_type, patient_id)" +
                " VALUES (?, ?)";

        PreparedStatement preparedStmt = c.prepareStatement(query);
        preparedStmt.setString (1, this.surgeryType);
        preparedStmt.setInt (2, this.getId());
        preparedStmt.execute();

        System.out.println("Surgery '" + this.surgeryType +  "' for " +
                "Patient '" + super.getId() + "' added to table 'SurgeryP'");
    }

    //inserts existing patient into table 'SurgeryP'
    public void insertExisting(Connection c) throws SQLException {

        String query = "INSERT INTO SurgeryP (surgery_type, patient_id)" +
                " VALUES (?, ?)";

        List<String> records = super.returnAll(c);
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).contains("id: " + this.getId() + ",")) {
                PreparedStatement preparedStmt = c.prepareStatement(query);
                preparedStmt.setString (1, this.surgeryType);
                preparedStmt.setInt (2, this.getId());
                preparedStmt.execute();

                System.out.println("Surgery '" + this.surgeryType +  "' for " +
                        "Patient '" + super.getId() + "' added to table 'SurgeryP'");
                return;
            }
        }
        System.out.println("Did not find a record in the database with this ID!");
    }

    //returns all rows in table 'SurgeryP'
    public static List<String> returnAll(Connection c) throws SQLException {
        List<String> list = new ArrayList<String>();
        setStatement(c.createStatement());

        String query = "SELECT * FROM SurgeryP";
        ResultSet rs = getStatement().executeQuery(query);
        String id, surgeryType;

        while (rs.next()) {
            id = "id: " + rs.getString("patient_id");
            surgeryType = ", surgeryType: " + rs.getString("surgery_type");

            list.add(id + surgeryType);
        }
        return list;
    }

    @Override
    public void delete(Connection c) throws SQLException {
        setStatement(c.createStatement());
        String query = "DELETE FROM SurgeryP WHERE patient_id = " + this.getId() + " AND " +
                "surgery_type = '" + this.surgeryType + "'";

        PreparedStatement preparedStmt = c.prepareStatement(query);
        preparedStmt.execute();

        System.out.println("Patient " + this.getId() + " with Surgery '" + this.surgeryType + "' deleted from table 'SurgeryP'");
    }

    @Override
    public String getMedication() {
        if (surgeryType.equals("Heart")) {
            return "Fentanyl";
        } else if (surgeryType.equals("Brain")) {
            return "Steroids";
        } else if (surgeryType.equals("Arm") || surgeryType.equals("Leg")) {
            return "Ibuprofen";
        } else if (surgeryType.equals("Lung")) {
            return "Bronchodilators";
        }

        return null;
    }
}
