package hospital;

public class Patient extends Person {

    private int ID;
    private String date;
    private String time;

    public Patient(String name, String age) {
        super(name, age);
    }

    public void print() {
        System.out.println("ID : " + ID);
        System.out.println("Date : " + date);
        System.out.println("Time : " + time);
    }

}
