package gui.inputs;

import gui.components.ComboBoxField;
import gui.components.DeleteButton;
import gui.components.Field;
import gui.components.SubmitButton;

public class NurseInput extends PersonInput {
    public NurseInput() {
        super();

        Field nurseIDField = new Field("Nurse ID", 20, getY(2), getFieldWidth(), getFieldHeight());

        String[] departments = {"Dekwaneh", "Beirut", "Sin El Fil"};
        ComboBoxField departmentField = new ComboBoxField("Department",
                20, getY(3), getFieldWidth(), getFieldHeight(), departments);

        this.textFields.add(nurseIDField.getTextField());
        this.comboBoxes.add(departmentField);

        SubmitButton submitButton = new SubmitButton("Nurse", this.textFields, this.comboBoxes);
        submitButton.setBounds(20, getY(4), (getFieldWidth() / 2) - 10, getFieldHeight());

        DeleteButton deleteButton = new DeleteButton("Nurse", this.textFields, this.comboBoxes);
        deleteButton.setBounds(20 + (getFieldWidth() / 2) + 10, getY(4),
                (getFieldWidth() / 2) - 10, getFieldHeight());

        this.add(nurseIDField);
        this.add(departmentField);
        this.add(submitButton);
        this.add(deleteButton);
    }
}