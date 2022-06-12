package gui.inputs;

import gui.components.ComboBoxField;
import gui.components.DeleteButton;
import gui.components.Field;
import gui.components.SubmitButton;

public class TreatementPInput extends PersonInput {
    public TreatementPInput() {
        super();

        Field patientIDField = new Field("Patient ID", 20, getY(2), getFieldWidth(), getFieldHeight());
        Field dateField = new Field("Date", 20, getY(3), getFieldWidth(), getFieldHeight());
        Field timeField = new Field("Time", 20, getY(4), getFieldWidth(), getFieldHeight());

        String[] treatementTypes = {"Chemotherapy", "Immunotherapy", "Radiation"};
        ComboBoxField treatementType = new ComboBoxField("Treatement Type",
                20, getY(5), getFieldWidth(), getFieldHeight(), treatementTypes);

        this.textFields.add(patientIDField.getTextField());
        this.textFields.add(dateField.getTextField());
        this.textFields.add(timeField.getTextField());
        this.comboBoxes.add(treatementType);

        SubmitButton submitButton = new SubmitButton("TreatementP", this.textFields, this.comboBoxes);
        submitButton.setBounds(20, getY(6), (getFieldWidth() / 2) - 10, getFieldHeight());

        DeleteButton deleteButton = new DeleteButton("TreatementP", this.textFields, this.comboBoxes);
        deleteButton.setBounds(20 + (getFieldWidth() / 2) + 10, getY(6),
                (getFieldWidth() / 2) - 10, getFieldHeight());

        this.add(patientIDField);
        this.add(dateField);
        this.add(timeField);
        this.add(treatementType);
        this.add(submitButton);
        this.add(deleteButton);
    }
}
