package gui.components;

import javax.swing.*;
import java.awt.*;

public class ComboBoxField extends JPanel {
    private JComboBox comboBox;

    public ComboBoxField(String name, int x, int y, int width, int height, String[] items) {
        this.setLayout(new BorderLayout(30, 0));
        this.setBackground(new Color(0xfff8f2));
        this.setBounds(x, y, width, height);

        JLabel label = new JLabel();
        label.setText(name);
        label.setFont(new Font("Calibri", Font.BOLD,20));

        comboBox = new JComboBox();
        comboBox.setFont(new Font("Calibri", Font.PLAIN,18));

        for (int i = 0; i < items.length; i++) {
            comboBox.addItem(items[i]);
        }

        this.add(label, BorderLayout.WEST);
        this.add(comboBox, BorderLayout.CENTER);

    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public Object getSelectedItem() {
        return comboBox.getSelectedItem();
    }
}
