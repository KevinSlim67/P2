package hospital;

import java.sql.*;

public class Medication {
    public static void main(String[] args) throws SQLException {
        Person[] people = new Person[10];

    }


    private void fillPeople(Person[] people) throws SQLException {
        String name;
        int age;
        for (int i = 0; i < people.length; i++) {
            name = "Person" + i;

            //Math.random() generates random value between 0 and 1
            //Math.random() * 100 makes the value between 0 and 90
            //Math.floor() ensures the value is a round number
            age = (int) Math.floor((Math.random() * 90));
        }
    }
}


