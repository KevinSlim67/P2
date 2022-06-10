package gui.components;

import gui.inputs.DoctorInput;
import gui.inputs.NurseInput;
import gui.inputs.PatientInput;
import gui.panels.InputData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ComboBox extends JComboBox implements ActionListener {
    private InputData inputPanel;
    private String[] items;

    public ComboBox(String[] items, InputData inputPanel) {
        this.inputPanel = inputPanel;
        this.items = Arrays.copyOf(items, items.length);
        this.setPreferredSize(new Dimension(100, 20));
        for (int i = 0; i < items.length; i++){
            this.addItem(items[i]);
        }
        this.addActionListener(e -> actionPerformed(e));
    }

    //what happens when you select a value from the combo box
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            inputPanel.removeAll();
            if (this.getSelectedItem().equals(items[0])) {
                inputPanel.add(new PatientInput(), BorderLayout.CENTER);
            } else if (this.getSelectedItem().equals(items[1])) {
                inputPanel.add(new NurseInput(), BorderLayout.CENTER);
            } else if (this.getSelectedItem().equals(items[2])) {
                inputPanel.add(new DoctorInput(), BorderLayout.CENTER);
            }
            inputPanel.revalidate();
        }
    }
}
