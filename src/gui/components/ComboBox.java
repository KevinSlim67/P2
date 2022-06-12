package gui.components;

import gui.inputs.*;
import gui.output.Output;
import gui.panels.ResultPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import static javax.swing.SwingConstants.CENTER;

public class ComboBox extends JComboBox implements ActionListener {
    private ResultPanel resultPanel;
    private String[] classes;
    private boolean isInput = true;

    public ComboBox(String[] items, ResultPanel resultPanel) {
        this.resultPanel = resultPanel;
        this.classes = Arrays.copyOf(items, items.length);
        this.setPreferredSize(new Dimension(200, 50));
        this.setFont(new Font("Calibri", Font.PLAIN, 18));
        this.setBackground(new Color(0xffe7c3));
        this.setForeground(new Color(0x402e32));

        //centers items in the list
        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        this.setRenderer(listRenderer);

        for (int i = 0; i < items.length; i++) {
            this.addItem(items[i]);
        }
        this.addActionListener(e -> actionPerformed(e));
    }

    //what happens when you select a value from the combo box
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
            resultPanel.removeAll();
            if (isInput) {
                inputPanels();
            } else {
                outputPanels();
            }
            resultPanel.revalidate();
            resultPanel.repaint();
        }
    }

    private void inputPanels() {
        if (this.getSelectedItem().equals(classes[0])) {
            resultPanel.add(new PatientInput(), BorderLayout.CENTER);
        } else if (this.getSelectedItem().equals(classes[1])) {
            resultPanel.add(new NurseInput(), BorderLayout.CENTER);
        } else if (this.getSelectedItem().equals(classes[2])) {
            resultPanel.add(new DoctorInput(), BorderLayout.CENTER);
        } else if (this.getSelectedItem().equals(classes[3])) {
            resultPanel.add(new TreatementPInput(), BorderLayout.CENTER);
        } else if (this.getSelectedItem().equals(classes[4])) {
            resultPanel.add(new SurgeryPInput(), BorderLayout.CENTER);
        } else if (this.getSelectedItem().equals(classes[5])) {
            resultPanel.add(new DayShiftInput(), BorderLayout.CENTER);
        } else if (this.getSelectedItem().equals(classes[6])) {
            resultPanel.add(new NightShiftInput(), BorderLayout.CENTER);
        }
    }

    private void outputPanels() {
        String className = this.getSelectedItem().toString();
        resultPanel.add(new Output(className));
    }

    public boolean isInput() {
        return isInput;
    }

    public void setInput(boolean input) {
        isInput = input;
    }
}
