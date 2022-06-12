package gui.panels;

import gui.output.Output;

import javax.swing.JPanel;
import java.awt.*;

public class Form extends JPanel {
    private ResultPanel resultPanel;
    private Output outputPanel;

    public Form() {
        this.setBackground(new Color(0xfff8f2)); //changes background color
        this.setLayout(new BorderLayout());

        resultPanel = new ResultPanel();
        this.add(resultPanel, BorderLayout.CENTER);

        SelectAction selectPanel = new SelectAction(resultPanel);
        this.add(selectPanel, BorderLayout.NORTH);

    }
}
