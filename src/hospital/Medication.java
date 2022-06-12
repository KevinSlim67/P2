package hospital;

public class Medication {
    public static void main(String[] args) {
        Person[] people = new Person[10];
        fillPeople(people);

        for (int i = 0; i < people.length; i++) {
            people[i].print();
        }

        
    }


    private static void fillPeople(Person[] people) {
        people[0] = new Patient("Kevin", 19, 1, "4/6/2019", "5:30 PM");
        people[1] = new SurgeryP("Charbel", 39, 2, "7/12/2016", "3:30 PM",
                "Heart");
        people[2] = new TreatementP("Mark", 23, 3, "1/2/2020", "3:30 PM",
                "Radiation");
        people[3] = new Nurse("Marie", 33, 1, "Dekwaneh");
        people[4] = new DayShift("Rita", 23, 2, "Beirut","1/1/2019",
                "8:00 AM");
        people[5] = new NightShift("Jack", 27, 3, "Beirut","5/1/2018",
                "9:00 PM");
        people[6] = new Doctor("Ahmad", 35, 1, "Neurosurgeon");
        people[7] = new Patient("Elissa", 25, 4, "9/1/2020", "3:30 PM");
        people[8] = new SurgeryP("George", 79, 5, "1/12/2015", "3:30 AM",
                "Brain");
        people[9] = new DayShift("Angela", 33, 4, "Sin El Fil","5/3/2018",
                "9:00 AM");
    }
}


