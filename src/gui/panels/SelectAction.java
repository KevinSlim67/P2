package gui.panels;

import gui.components.ComboBox;
import gui.inputs.PatientInput;
import gui.output.Output;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static javax.swing.SwingConstants.CENTER;

public class SelectAction extends JPanel {
    private ResultPanel resultPanel;
    private Output outputData;
    private ComboBox comboBox;
    private JButton inputBtn;
    private JButton outputBtn;

    public SelectAction(ResultPanel resultPanel) {
        this.resultPanel = resultPanel;
        this.setPreferredSize(new Dimension(500, 50));
        this.setOpaque(false);
        this.setLayout(new GridLayout(1,3,40,0));

        String[] items = {"Patient", "Nurse", "Doctor", "TreatementP", "SurgeryP", "DayShift", "NightShift"};
        comboBox = new ComboBox(items, resultPanel);

        inputBtn = new JButton();
        inputBtn.setText("Input");
        formatButton(inputBtn, true);

        outputBtn = new JButton();
        outputBtn.setText("Output");
        formatButton(outputBtn, false);

        this.add(inputBtn);
        this.add(comboBox);
        this.add(outputBtn);

    }

    private void isInput(ActionEvent e, boolean isInput) {
        if (e.getSource() == inputBtn || e.getSource() == outputBtn) {
            comboBox.setInput(isInput);

            if (isInput) {
                resultPanel.removeAll();
                resultPanel.add(new PatientInput());
            } else {
                resultPanel.removeAll();
                resultPanel.add(new Output("Patient"));
            }

            comboBox.revalidate();
        }
    }

    private void formatButton(JButton btn, boolean isInput) {
        btn.setBounds(0, 0, 100, 50);
        btn.addActionListener(e -> isInput(e, isInput));
        btn.setBackground(new Color(0xffe7c3));
        btn.setForeground(new Color(0x402e32));
        btn.setFont(new Font("Calibri", Font.PLAIN, 18));
        btn.setBorder(BorderFactory.createEtchedBorder());
        btn.setHorizontalTextPosition(CENTER);
        btn.setVerticalTextPosition(CENTER);
    }
}
