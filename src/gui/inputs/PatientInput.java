package gui.inputs;

import gui.components.Field;
import gui.components.SubmitButton;

public class PatientInput extends PersonInput {
    public PatientInput() {
        super();

        Field patientIDField = new Field("Patient ID", 20, getY(2), getFieldWidth(), getFieldHeight());
        Field dateField = new Field("Date", 20, getY(3), getFieldWidth(), getFieldHeight());
        Field timeField = new Field("Time", 20, getY(4), getFieldWidth(), getFieldHeight());

        this.textFields.add(patientIDField.getTextField());
        this.textFields.add(dateField.getTextField());
        this.textFields.add(timeField.getTextField());

        SubmitButton submitButton = new SubmitButton("Patient", this.textFields, this.comboBoxes);
        submitButton.setBounds(20, getY(5), getFieldWidth(), getFieldHeight());


        this.add(patientIDField);
        this.add(dateField);
        this.add(timeField);
        this.add(submitButton);
    }
}
