package gui.inputs;

import gui.components.Field;
import gui.components.SubmitButton;

public class SurgeryPInput extends PersonInput {
    public SurgeryPInput() {
        super();

        Field patientIDField = new Field("Patient ID", 20, 150, getFieldWidth(), getFieldHeight());
        Field dateField = new Field("Date", 20, 210, getFieldWidth(), getFieldHeight());
        Field timeField = new Field("Time", 20, 280, getFieldWidth(), getFieldHeight());
        Field surgeryType = new Field("Surgery Type", 20, 340, getFieldWidth(), getFieldHeight());

        this.textFields.add(patientIDField.getTextField());
        this.textFields.add(dateField.getTextField());
        this.textFields.add(timeField.getTextField());
        this.textFields.add(surgeryType.getTextField());

        SubmitButton submitButton = new SubmitButton("SurgeryP", this.textFields);
        submitButton.setBounds(20, 400, getFieldWidth(), getFieldHeight());


        this.add(patientIDField);
        this.add(dateField);
        this.add(timeField);
        this.add(surgeryType);
        this.add(submitButton);
    }
}
