package gui.components;

import db.DB;
import hospital.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SubmitButton extends JButton {

    private List<JTextField> textFields;
    private List<ComboBoxField> comboBoxes;
    private String table;

    public SubmitButton(String table, List<JTextField> textFields, List<ComboBoxField> comboBoxes) {
        this.table = table;
        this.textFields = textFields;
        this.comboBoxes = comboBoxes;
        this.setBackground(new Color(0xffe7c3));
        this.setFont(new Font("Calibri", Font.PLAIN, 18));
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setHorizontalTextPosition(CENTER);
        this.setVerticalTextPosition(CENTER);
        this.setVisible(true);
        this.setText("Submit");

        this.addActionListener(e -> {
            try {
                actionPerformed(e);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });
    }

    public void actionPerformed(ActionEvent e) throws SQLException {
        if (e.getSource() == this) {
            if (table.equals("Patient")) {
                createPatient();
            } else if (table.equals("Nurse")) {
                createNurse();
            } else if (table.equals("Doctor")) {
                createDoctor();
            } else if (table.equals("TreatementP")) {
                createTreatementP();
            } else if (table.equals("SurgeryP")) {
                createSurgeryP();
            } else if (table.equals("DayShift")) {
                createShift("day");
            } else if (table.equals("NightShift")) {
                createShift("night");
            }

        }
    }

    private void createPatient() throws SQLException {
        String name = textFields.get(0).getText();
        int age = Integer.valueOf(textFields.get(1).getText());
        int id = Integer.valueOf(textFields.get(2).getText());
        String date = textFields.get(3).getText();
        String time = textFields.get(4).getText();
        Patient patient = new Patient(name, age, id, date, time);

        Connection connection = DB.connectToDatabase();
        patient.insert(connection);
        connection.close();
    }

    private void createNurse() throws SQLException {
        String name = textFields.get(0).getText();
        int age = Integer.valueOf(textFields.get(1).getText());
        int id = Integer.valueOf(textFields.get(2).getText());
        String department = comboBoxes.get(0).getSelectedItem().toString();
        Nurse nurse = new Nurse(name, age, id, department);

        Connection connection = DB.connectToDatabase();
        nurse.insert(connection);
        connection.close();
    }

    private void createDoctor() throws SQLException {
        String name = textFields.get(0).getText();
        int age = Integer.valueOf(textFields.get(1).getText());
        int id = Integer.valueOf(textFields.get(2).getText());
        String spec = comboBoxes.get(0).getSelectedItem().toString();
        Doctor doctor = new Doctor(name, age, id, spec);

        Connection connection = DB.connectToDatabase();
        doctor.insert(connection);
        connection.close();
    }

    private void createTreatementP() throws SQLException {

        String name = textFields.get(0).getText();
        int age = Integer.valueOf(textFields.get(1).getText());
        int id = Integer.valueOf(textFields.get(2).getText());
        String date = textFields.get(3).getText();
        String time = textFields.get(4).getText();
        String treatementType = comboBoxes.get(0).getSelectedItem().toString();
        TreatementP treatementP = new TreatementP(name, age, id, date, time, treatementType);

        Connection connection = DB.connectToDatabase();

        if (treatementP.searchTable(connection)) {
            treatementP.insertExisting(connection);
        } else {
            treatementP.insert(connection);
        }

        connection.close();
    }

    private void createSurgeryP() throws SQLException {

        String name = textFields.get(0).getText();
        int age = Integer.valueOf(textFields.get(1).getText());
        int id = Integer.valueOf(textFields.get(2).getText());
        String date = textFields.get(3).getText();
        String time = textFields.get(4).getText();
        String surgeryType = comboBoxes.get(0).getSelectedItem().toString();
        SurgeryP surgeryP = new SurgeryP(name, age, id, date, time, surgeryType);

        Connection connection = DB.connectToDatabase();

        if (surgeryP.searchTable(connection)) {
            surgeryP.insertExisting(connection);
        } else {
            surgeryP.insert(connection);
        }

        connection.close();
    }

    private void createShift(String shift) throws SQLException {

        String name = textFields.get(0).getText();
        int age = Integer.valueOf(textFields.get(1).getText());
        int id = Integer.valueOf(textFields.get(2).getText());
        String department = comboBoxes.get(0).getSelectedItem().toString();
        String date = textFields.get(3).getText();
        String time = textFields.get(4).getText();

        Connection connection = DB.connectToDatabase();

        if (shift.equals("day")) {
            DayShift dayShift = new DayShift(name, age, id, department, date, time);
            if (dayShift.searchTable(connection)) {
                dayShift.insertExisting(connection);
            } else {
                dayShift.insert(connection);
            }

        } else if (shift.equals("night")) {
            NightShift nightShift = new NightShift(name, age, id, department, date, time);
            if (nightShift.searchTable(connection)) {
                nightShift.insertExisting(connection);
            } else {
                nightShift.insert(connection);
            }
        }

        connection.close();
    }
}
