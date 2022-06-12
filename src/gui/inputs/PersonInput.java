package gui.inputs;

import gui.components.ComboBoxField;
import gui.components.Field;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public abstract class PersonInput extends JPanel {
    List<JTextField> textFields;
    List<ComboBoxField> comboBoxes;
    final int fieldWidth = 400;
    final int fieldHeight = 40;
    public PersonInput() {
        textFields = new ArrayList<JTextField>();
        comboBoxes = new ArrayList<ComboBoxField>();

        this.setLayout(null);
        this.setOpaque(false); //makes background transparent

        Field nameField = new Field("Name", 20, getY(0), fieldWidth, fieldHeight);
        Field ageField = new Field("Age", 20, getY(1), fieldWidth, fieldHeight);

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

    int getY(int increment) {
        return 20 + (60 * increment);
    }
}
