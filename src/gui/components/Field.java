package gui.components;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    private JTextField textField;

    public Field(String name, int x, int y, int width, int height) {
        this.setLayout(new BorderLayout(30, 0));
        this.setBackground(new Color(0xfff8f2));
        this.setBounds(x, y, width, height);

        JLabel label = new JLabel();
        label.setText(name);
        label.setFont(new Font("Calibri", Font.BOLD,20));

        textField = new JTextField();
        textField.setFont(new Font("Calibri", Font.PLAIN,18));
        textField.setMargin(new Insets(10, 10, 10, 10));

        this.add(label, BorderLayout.WEST);
        this.add(textField, BorderLayout.CENTER);

    }

    public JTextField getTextField() {
        return textField;
    }
}
