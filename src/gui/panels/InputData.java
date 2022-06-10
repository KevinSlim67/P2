package gui.panels;

import gui.inputs.DoctorInput;
import gui.inputs.NurseInput;
import gui.inputs.PatientInput;

import javax.swing.*;
import java.awt.*;

public class InputData extends JPanel {

    public InputData() {
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(0xfff8e8)); //changes background color
        this.add(new PatientInput(), BorderLayout.CENTER);
        this.setVisible(true);
    }

}
