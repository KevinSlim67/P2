package gui.inputs;

import gui.components.ComboBoxField;
import gui.components.Field;
import gui.components.SubmitButton;

public class DayShiftInput extends PersonInput {


    public DayShiftInput() {
        super();

        Field nurseIDField = new Field("Nurse ID", 20, getY(2), getFieldWidth(), getFieldHeight());

        String[] departments = {"Dekwaneh", "Beirut", "Sin El Fil"};
        ComboBoxField departmentField = new ComboBoxField("Department",
                20, getY(3), getFieldWidth(), getFieldHeight(), departments);

        Field dateField = new Field("Date", 20, getY(4), getFieldWidth(), getFieldHeight());
        Field timeField = new Field("Time", 20, getY(5), getFieldWidth(), getFieldHeight());

        this.textFields.add(nurseIDField.getTextField());
        this.comboBoxes.add(departmentField);
        this.textFields.add(dateField.getTextField());
        this.textFields.add(timeField.getTextField());

        SubmitButton submitButton = new SubmitButton("DayShift", this.textFields, this.comboBoxes);
        submitButton.setBounds(20, getY(6), getFieldWidth(), getFieldHeight());

        this.add(nurseIDField);
        this.add(departmentField);
        this.add(dateField);
        this.add(timeField);
        this.add(submitButton);
    }
}