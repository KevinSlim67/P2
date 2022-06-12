package gui.inputs;

import gui.components.ComboBoxField;
import gui.components.Field;
import gui.components.SubmitButton;

public class DoctorInput extends PersonInput {
    public DoctorInput() {
        super();

        Field doctorIDField = new Field("Doctor ID", 20, getY(2), getFieldWidth(), getFieldHeight());

        String[] specs = {"Cardiothoracic Surgeon", "Neurosurgeon", "Thoracic Surgeon", "Plastic Surgeon", "Oncologist"};
        ComboBoxField specField = new ComboBoxField("Specialisation",
                20, getY(3), getFieldWidth(), getFieldHeight(), specs);

        this.textFields.add(doctorIDField.getTextField());
        this.comboBoxes.add(specField);

        SubmitButton submitButton = new SubmitButton("Doctor", this.textFields, this.comboBoxes);
        submitButton.setBounds(20, getY(4), getFieldWidth(), getFieldHeight());

        this.add(doctorIDField);
        this.add(specField);
        this.add(submitButton);
    }
}
