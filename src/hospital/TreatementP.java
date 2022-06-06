package hospital;

public class TreatementP extends Patient implements Hospital{

    private String treatementType;

    public TreatementP(String name, String age) {
        super(name, age);
    }

    @Override
    public void getMedication() {

    }
}
