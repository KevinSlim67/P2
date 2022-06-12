package gui.panels;

import gui.inputs.PatientInput;

import javax.swing.*;
import java.awt.*;

public class ResultPanel extends JPanel {

    public ResultPanel() {
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        this.add(new PatientInput(), BorderLayout.CENTER);
        this.setVisible(true);
    }

}
