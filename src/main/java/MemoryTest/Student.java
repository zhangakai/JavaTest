package MemoryTest;

public class Student extends Preson{
    private int age;
    private String name;

    public Student(int age, String name) {
        super(age,name);
        this.age = age;
        this.name = name;
    }

    public Student() {
        System.out.println(1);
    }
}
