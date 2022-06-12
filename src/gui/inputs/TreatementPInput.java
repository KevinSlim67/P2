package gui.inputs;

import gui.components.ComboBoxField;
import gui.components.Field;
import gui.components.SubmitButton;

public class TreatementPInput extends PersonInput {
    public TreatementPInput() {
        super();

        Field patientIDField = new Field("Patient ID", 20, 150, getFieldWidth(), getFieldHeight());
        Field dateField = new Field("Date", 20, 210, getFieldWidth(), getFieldHeight());
        Field timeField = new Field("Time", 20, 280, getFieldWidth(), getFieldHeight());

        String[] treatementTypes = {"Chemotherapy", "Immunotherapy", "Radiation"};
        ComboBoxField treatementType = new ComboBoxField("Treatement Type",
                20, 340, getFieldWidth(), getFieldHeight(), treatementTypes);

        this.textFields.add(patientIDField.getTextField());
        this.textFields.add(dateField.getTextField());
        this.textFields.add(timeField.getTextField());
        this.comboBoxes.add(treatementType);

        SubmitButton submitButton = new SubmitButton("TreatementP", this.textFields, this.comboBoxes);
        submitButton.setBounds(20, 400, getFieldWidth(), getFieldHeight());


        this.add(patientIDField);
        this.add(dateField);
        this.add(timeField);
        this.add(treatementType);
        this.add(submitButton);
    }
}
