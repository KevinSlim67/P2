package gui.inputs;

import gui.components.Field;
import gui.components.SubmitButton;

public class NurseInput extends PersonInput {
    public NurseInput() {
        super();

        Field nurseIDField = new Field("Nurse ID", 20, 150, getFieldWidth(), getFieldHeight());
        Field departmentField = new Field("Department", 20, 210, getFieldWidth(), getFieldHeight());

        this.textFields.add(nurseIDField.getTextField());
        this.textFields.add(departmentField.getTextField());

        SubmitButton submitButton = new SubmitButton("Nurse", this.textFields);
        submitButton.setBounds(20, 340, getFieldWidth(), getFieldHeight());

        this.add(nurseIDField);
        this.add(departmentField);
        this.add(submitButton);
    }
}