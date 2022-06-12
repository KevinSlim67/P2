package gui.inputs;

import gui.components.Field;
import gui.components.SubmitButton;

public class DoctorInput extends PersonInput {
    public DoctorInput() {
        super();

        Field doctorIDField = new Field("Doctor ID", 20, 150, getFieldWidth(), getFieldHeight());
        Field specField = new Field("Spec", 20, 210, getFieldWidth(), getFieldHeight());

        this.textFields.add(doctorIDField.getTextField());
        this.textFields.add(specField.getTextField());

        SubmitButton submitButton = new SubmitButton("Doctor", this.textFields);
        submitButton.setBounds(20, 340, getFieldWidth(), getFieldHeight());

        this.add(doctorIDField);
        this.add(specField);
        this.add(submitButton);
    }
}
