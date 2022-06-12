package hospital;

import db.SQL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TreatementP extends Patient implements Hospital, SQL {

    private String treatementType;

    public TreatementP(String name, int age, int id, String date, String time, String treatementType) {
        super(name, age, id, date, time);
        this.treatementType = treatementType;
    }

    //inserts into table 'TreatementP'
    @Override
    public void insert(Connection c) throws SQLException {
        super.insert(c);

        String query = "INSERT INTO TreatementP (treatement_type, patient_id)" +
                " VALUES (?, ?)";

        PreparedStatement preparedStmt = c.prepareStatement(query);
        preparedStmt.setString (1, this.treatementType);
        preparedStmt.setInt (2, this.getId());
        preparedStmt.execute();

        System.out.println("Surgery '" + this.treatementType +  "' for " +
                "Patient '" + super.getName() + "' added to table 'TreatementP'");
    }

    //inserts existing patient into table 'TreatementP'
    public void insertExisting(Connection c) throws SQLException {
        setStatement(c.createStatement());

        String query = "INSERT INTO TreatementP (treatement_type, patient_id)" +
                " VALUES (?, ?)";

        List<String> records = super.returnAll(c);
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).contains("id: " + this.getId() + ",")) {
                PreparedStatement preparedStmt = c.prepareStatement(query);
                preparedStmt.setString (1, this.treatementType);
                preparedStmt.setInt (2, this.getId());
                preparedStmt.execute();

                System.out.println("Treatement '" + this.treatementType +  "' for " +
                        "Patient '" + super.getName() + "' added to table 'TreatementP'");
                return;
            }
        }
        System.out.println("Did not find a record in the database with this ID!");
    }

    //returns all rows in table 'TreatementP'
    public static List<String> returnAll(Connection c) throws SQLException {
        List<String> list = new ArrayList<String>();
        setStatement(c.createStatement());

        String query = "SELECT * FROM TreatementP";
        ResultSet rs = getStatement().executeQuery(query);
        String id, treatementType;

        while (rs.next()) {
            id = "id: " + rs.getString("patient_id");
            treatementType = ", treatementType: " + rs.getString("treatement_type");

            list.add(id + treatementType);
        }
        return list;
    }

    @Override
    public void getMedication() {

    }

    public String getTreatementType() {
        return treatementType;
    }

    public void setTreatementType(String treatementType) {
        this.treatementType = treatementType;
    }
}
