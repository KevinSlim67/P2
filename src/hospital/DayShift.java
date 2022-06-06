package hospital;

public class DayShift extends Nurse implements Hospital{

    private String shift;
    private String time;

    public DayShift(String name, String age) {
        super(name, age);
    }

    @Override
    public void getMedication() {

    }
}
