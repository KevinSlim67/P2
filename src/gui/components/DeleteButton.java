package gui.components;

import db.DB;
import hospital.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DeleteButton extends JButton {

    private List<JTextField> textFields;
    private List<ComboBoxField> comboBoxes;
    private String table;

    public DeleteButton(String table, List<JTextField> textFields, List<ComboBoxField> comboBoxes) {
        this.table = table;
        this.textFields = textFields;
        this.comboBoxes = comboBoxes;
        this.setBackground(new Color(0xffe7c3));
        this.setFont(new Font("Calibri", Font.PLAIN, 18));
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setHorizontalTextPosition(CENTER);
        this.setVerticalTextPosition(CENTER);
        this.setVisible(true);
        this.setText("Delete");

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
                deletePatient();
            } else if (table.equals("Nurse")) {
                deleteNurse();
            } else if (table.equals("Doctor")) {
                deleteDoctor();
            } else if (table.equals("TreatementP")) {
                deleteTreatementP();
            } else if (table.equals("SurgeryP")) {
                deleteSurgeryP();
            } else if (table.equals("DayShift")) {
                deleteShift("day");
            } else if (table.equals("NightShift")) {
                deleteShift("night");
            }

        }
    }

    private void deletePatient() throws SQLException {
        String name = textFields.get(0).getText();
        int age = Integer.valueOf(textFields.get(1).getText());
        int id = Integer.valueOf(textFields.get(2).getText());
        String date = textFields.get(3).getText();
        String time = textFields.get(4).getText();
        Patient patient = new Patient(name, age, id, date, time);

        Connection connection = DB.connectToDatabase();
        patient.delete(connection);
        connection.close();
    }

    private void deleteNurse() throws SQLException {
        String name = textFields.get(0).getText();
        int age = Integer.valueOf(textFields.get(1).getText());
        int id = Integer.valueOf(textFields.get(2).getText());
        String department = comboBoxes.get(0).getSelectedItem().toString();
        Nurse nurse = new Nurse(name, age, id, department);

        Connection connection = DB.connectToDatabase();
        nurse.delete(connection);
        connection.close();
    }

    private void deleteDoctor() throws SQLException {
        String name = textFields.get(0).getText();
        int age = Integer.valueOf(textFields.get(1).getText());
        int id = Integer.valueOf(textFields.get(2).getText());
        String spec = comboBoxes.get(0).getSelectedItem().toString();
        Doctor doctor = new Doctor(name, age, id, spec);

        Connection connection = DB.connectToDatabase();
        doctor.delete(connection);
        connection.close();
    }

    private void deleteTreatementP() throws SQLException {

        String name = textFields.get(0).getText();
        int age = Integer.valueOf(textFields.get(1).getText());
        int id = Integer.valueOf(textFields.get(2).getText());
        String date = textFields.get(3).getText();
        String time = textFields.get(4).getText();
        String treatementType = comboBoxes.get(0).getSelectedItem().toString();
        TreatementP treatementP = new TreatementP(name, age, id, date, time, treatementType);

        Connection connection = DB.connectToDatabase();
        treatementP.delete(connection);
        connection.close();
    }

    private void deleteSurgeryP() throws SQLException {

        String name = textFields.get(0).getText();
        int age = Integer.valueOf(textFields.get(1).getText());
        int id = Integer.valueOf(textFields.get(2).getText());
        String date = textFields.get(3).getText();
        String time = textFields.get(4).getText();
        String surgeryType = comboBoxes.get(0).getSelectedItem().toString();
        SurgeryP surgeryP = new SurgeryP(name, age, id, date, time, surgeryType);

        Connection connection = DB.connectToDatabase();
        surgeryP.delete(connection);
        connection.close();
    }

    private void deleteShift(String shift) throws SQLException {

        String name = textFields.get(0).getText();
        int age = Integer.valueOf(textFields.get(1).getText());
        int id = Integer.valueOf(textFields.get(2).getText());
        String department = comboBoxes.get(0).getSelectedItem().toString();
        String date = textFields.get(3).getText();
        String time = textFields.get(4).getText();

        Connection connection = DB.connectToDatabase();

        if (shift.equals("day")) {
            DayShift dayShift = new DayShift(name, age, id, department, date, time);
            dayShift.delete(connection);
        } else if (shift.equals("night")) {
            NightShift nightShift = new NightShift(name, age, id, department, date, time);
            nightShift.delete(connection);
        }
        connection.close();
    }
}
