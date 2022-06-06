package hospital;

public class NightShift extends Nurse implements Hospital {

    private String shift;
    private String time;

    public NightShift(String name, String age) {
        super(name, age);
    }

    @Override
    public void getMedication() {

    }
}
