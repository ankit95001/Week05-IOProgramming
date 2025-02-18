package com.ioprogramming.day01csvdatahandling.intermediateproblems.filterrecords;

class Student {
    int id;
    String name;
    int age;
    double marks;

    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Age: %d | Marks: %.2f", id, name, age, marks);
    }
}
