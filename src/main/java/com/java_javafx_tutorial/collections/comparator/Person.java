package com.java_javafx_tutorial.collections.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person {
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
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
class AgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
class Main{
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John Doe", 18));
        people.add(new Person("Serkan Cort", 28));
        people.add(new Person("Ahmet Sara", 25));
        people.add(new Person("Michael Brown", 27));
        people.add(new Person("Ibrahim Aslan", 23));
        //isimlere göre sıralama
        Collections.sort(people, new NameComparator());
        System.out.println("isimlere göre sıralama");
        for (Person p : people) {
            System.out.println(p);
        }
        //yaşa göre sıralama
        //lambda expression ile
        Collections.sort(people, (s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));
        System.out.println("yaşa göre sıralama");
        for (Person p : people) {
            System.out.println(p);
        }
    }
}
