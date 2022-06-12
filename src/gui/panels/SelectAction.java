package gui.panels;

import gui.components.ComboBox;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SelectAction extends JPanel {

    public SelectAction(InputData inputPanel) {
        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(new Color(0xfff3d6));

        String[] items = {"Patient", "Nurse", "Doctor", "TreatementP", "SurgeryP", "DayShift", "NightShift"};
        ComboBox comboBox = new ComboBox(items, inputPanel);
        comboBox.setAlignmentX(CENTER_ALIGNMENT);
        comboBox.setAlignmentY(BOTTOM_ALIGNMENT);
        this.add(comboBox);

    }
}
