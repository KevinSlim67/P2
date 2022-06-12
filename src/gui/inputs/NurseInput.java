package gui.inputs;

import gui.components.ComboBoxField;
import gui.components.Field;
import gui.components.SubmitButton;

public class NurseInput extends PersonInput {
    public NurseInput() {
        super();

        Field nurseIDField = new Field("Nurse ID", 20, 150, getFieldWidth(), getFieldHeight());

        String[] departments = {"Dekwaneh", "Beirut", "Sin El Fil"};
        ComboBoxField departmentField = new ComboBoxField("Department",
                20, 210, getFieldWidth(), getFieldHeight(), departments);

        this.textFields.add(nurseIDField.getTextField());
        this.comboBoxes.add(departmentField);

        SubmitButton submitButton = new SubmitButton("Nurse", this.textFields, this.comboBoxes);
        submitButton.setBounds(20, 340, getFieldWidth(), getFieldHeight());

        this.add(nurseIDField);
        this.add(departmentField);
        this.add(submitButton);
    }
}