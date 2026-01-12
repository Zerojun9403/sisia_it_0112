package com.sisa;

public class Person {

    int no;
    String name;
    int age;
    String job;

    public Person() {}

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    @Override
    public String toString() {
        return no + "\t" + name + "\t" + age + "\t" + job;
    }
}
