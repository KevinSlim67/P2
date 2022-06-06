package hospital;

public class Person {
    private String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void print() {
        System.out.println("Name : " + name);
        System.out.println("Age : " + age);
    }
}
