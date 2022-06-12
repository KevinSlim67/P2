package gui.output;

import db.DB;
import hospital.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Output extends JPanel {
    private String className;
    JLabel label = new JLabel();

    public Output(String className) {
        this.className = className;
        this.setBackground(new Color(0xfff8f2)); //changes background color

        Connection connection = DB.connectToDatabase();

        try {
            displayData(returnData(connection));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List returnData(Connection c) throws SQLException {
        if (className.equals("Patient")) {
            return Patient.returnAll(c);
        } else if (className.equals("Nurse")) {
            return Nurse.returnAll(c);
        } else if (className.equals("Nurse")) {
            return Nurse.returnAll(c);
        } else if (className.equals("Doctor")) {
            return Doctor.returnAll(c);
        } else if (className.equals("TreatementP")) {
            return TreatementP.returnAll(c);
        } else if (className.equals("SurgeryP")) {
            return SurgeryP.returnAll(c);
        } else if (className.equals("DayShift")) {
            return DayShift.returnAll(c);
        } else if (className.equals("NightShift")) {
            return NightShift.returnAll(c);
        }

        return null;
    }

    private void displayData(List<String> list) {
        String text = "<html>";
        for (int i = 0; i < list.size(); i++) {
            text += (list.get(i)+"<br/>");
        }
        text.concat("<html>");
        label.setText(text);
        formatLabel(label);
        this.add(label);
    }

    private void formatLabel(JLabel label) {
        label.setFont(new Font("Calibri", Font.PLAIN, 20));

        final int space = 20;
        Border margin = new EmptyBorder(space,space,space,space);
        label.setBorder(margin);
    }

}

