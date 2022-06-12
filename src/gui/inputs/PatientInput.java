package gui.inputs;

import gui.components.Field;
import gui.components.SubmitButton;

public class PatientInput extends PersonInput {
    public PatientInput() {
        super();

        Field patientIDField = new Field("Patient ID", 20, 150, getFieldWidth(), getFieldHeight());
        Field dateField = new Field("Date", 20, 210, getFieldWidth(), getFieldHeight());
        Field timeField = new Field("Time", 20, 280, getFieldWidth(), getFieldHeight());

        this.textFields.add(patientIDField.getTextField());
        this.textFields.add(dateField.getTextField());
        this.textFields.add(timeField.getTextField());

        SubmitButton submitButton = new SubmitButton("Patient", this.textFields, this.comboBoxes);
        submitButton.setBounds(20, 340, getFieldWidth(), getFieldHeight());


        this.add(patientIDField);
        this.add(dateField);
        this.add(timeField);
        this.add(submitButton);
    }
}
