package gui.components;

import javax.swing.*;
import java.awt.*;

public class ComboBoxField extends JPanel {
    private JComboBox comboBox;

    public ComboBoxField(String name, int x, int y, int width, int height, String[] items) {
        this.setLayout(new BorderLayout(30, 0));
        this.setOpaque(false);
        this.setBounds(x, y, width, height);

        JLabel label = new JLabel();
        label.setText(name);
        label.setFont(new Font("Calibri", Font.BOLD,20));

        comboBox = new JComboBox();
        comboBox.setFont(new Font("Calibri", Font.PLAIN,18));
        comboBox.setBackground(Color.WHITE);

        //centers items in the list
        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        comboBox.setRenderer(listRenderer);

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
