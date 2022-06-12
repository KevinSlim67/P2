package gui.inputs;

import gui.components.ComboBoxField;
import gui.components.Field;
import gui.components.SubmitButton;

public class SurgeryPInput extends PersonInput {
    public SurgeryPInput() {
        super();

        Field patientIDField = new Field("Patient ID", 20, getY(2), getFieldWidth(), getFieldHeight());
        Field dateField = new Field("Date", 20, getY(3), getFieldWidth(), getFieldHeight());
        Field timeField = new Field("Time", 20, getY(4), getFieldWidth(), getFieldHeight());

        String[] surgeryTypes = {"Heart", "Lung", "Brain", "Leg", "Arm"};
        ComboBoxField surgeryType = new ComboBoxField("Surgery Type",
                20, getY(5), getFieldWidth(), getFieldHeight(), surgeryTypes);

        this.textFields.add(patientIDField.getTextField());
        this.textFields.add(dateField.getTextField());
        this.textFields.add(timeField.getTextField());
        this.comboBoxes.add(surgeryType);

        SubmitButton submitButton = new SubmitButton("SurgeryP", this.textFields, this.comboBoxes);
        submitButton.setBounds(20, getY(6), getFieldWidth(), getFieldHeight());


        this.add(patientIDField);
        this.add(dateField);
        this.add(timeField);
        this.add(surgeryType);
        this.add(submitButton);
    }
}
