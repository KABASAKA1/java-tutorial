package com.java_javafx_tutorial.collections.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    //Comparable interface'inin methodunu implement etme
    @Override
    public int compareTo(Person person) {
        return Integer.compare(this.age, person.age);
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
class Main{
    public static void main(String[] args) {
        //bir person listesi oluşturma
        List<Person> people = new ArrayList<>();
        people.add(new Person("serkan" ,28));
        people.add(new Person("ibrahim" ,23));
        people.add(new Person("kaan" ,21));
        people.add(new Person("mert" ,21));
        //person listesini sıralama
        Collections.sort(people);
        for (Person person : people) {
            System.out.println(person); //listeyi yazma
        }
    }
}
