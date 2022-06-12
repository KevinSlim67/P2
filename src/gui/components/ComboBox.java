package gui.components;

import gui.inputs.*;
import gui.panels.InputData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ComboBox extends JComboBox implements ActionListener {
    private InputData inputPanel;
    private String[] classes;

    public ComboBox(String[] items, InputData inputPanel) {
        this.inputPanel = inputPanel;
        this.classes = Arrays.copyOf(items, items.length);
        this.setPreferredSize(new Dimension(200, 50));
        this.setFont(new Font("Calibri", Font.PLAIN, 20));
        this.setForeground(new Color(0xa76300));

        for (int i = 0; i < items.length; i++) {
            this.addItem(items[i]);
        }
        this.addActionListener(e -> actionPerformed(e));
    }

    //what happens when you select a value from the combo box
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            inputPanel.removeAll();
            if (this.getSelectedItem().equals(classes[0])) {
                inputPanel.add(new PatientInput(), BorderLayout.CENTER);
            } else if (this.getSelectedItem().equals(classes[1])) {
                inputPanel.add(new NurseInput(), BorderLayout.CENTER);
            } else if (this.getSelectedItem().equals(classes[2])) {
                inputPanel.add(new DoctorInput(), BorderLayout.CENTER);
            } else if (this.getSelectedItem().equals(classes[3])) {
                inputPanel.add(new TreatementPInput(), BorderLayout.CENTER);
            } else if (this.getSelectedItem().equals(classes[4])) {
                inputPanel.add(new SurgeryPInput(), BorderLayout.CENTER);
            } else if (this.getSelectedItem().equals(classes[5])) {
                inputPanel.add(new DayShiftInput(), BorderLayout.CENTER);
            } else if (this.getSelectedItem().equals(classes[6])) {
                inputPanel.add(new NightShiftInput(), BorderLayout.CENTER);
            }
            inputPanel.revalidate();
        }
    }
}
