package gui.panels;

import javax.swing.JPanel;
import java.awt.*;

public class Form extends JPanel {
    private InputData inputPanel;

    public Form() {
        this.setBackground(Color.white); //changes background color
        this.setLayout(new BorderLayout());

        inputPanel = new InputData();
        this.add(inputPanel, BorderLayout.CENTER);

        SelectAction selectPanel = new SelectAction(inputPanel);
        this.add(selectPanel, BorderLayout.NORTH);

    }

    public InputData getInputPanel() {
        return inputPanel;
    }
}
