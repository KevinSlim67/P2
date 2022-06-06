package hospital;

public class SurgeryP extends Patient implements Hospital {
    String surgeryType;

    public SurgeryP(String name, String age) {
        super(name, age);
    }

    @Override
    public void getMedication() {

    }
}
