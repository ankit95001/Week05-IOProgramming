package com.ioprogramming.day01csvdatahandling.advancedproblems.convertcsv;

class Student {
    int id;
    String name;
    int age;
    double marks;

    // Constructor
    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student { ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks + " }";
    }
}

