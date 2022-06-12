package gui.inputs;

import gui.components.Field;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public abstract class PersonInput extends JPanel {
    List<JTextField> textFields;
    final int fieldWidth = 400;
    final int fieldHeight = 40;
    public PersonInput() {
        textFields = new ArrayList<JTextField>();

        this.setLayout(null);
        this.setBackground(new Color(0xfff8f2)); //changes background color

        Field nameField = new Field("Name", 20, 30, fieldWidth, fieldHeight);
        Field ageField = new Field("Age", 20, 90, fieldWidth, fieldHeight);

        //adding all the textfields of each field to this list, in order to access the data
        //when we press the submit button
        textFields.add(nameField.getTextField());
        textFields.add(ageField.getTextField());

        this.add(nameField);
        this.add(ageField);
    }

    public int getFieldHeight() {
        return fieldHeight;
    }

    public int getFieldWidth() {
        return fieldWidth;
    }
}
