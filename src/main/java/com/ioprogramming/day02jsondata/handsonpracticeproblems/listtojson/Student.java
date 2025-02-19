package com.ioprogramming.day02jsondata.handsonpracticeproblems.listtojson;


class Student {
    String name;
    int age;
    String email;

    // Default constructor (required for Jackson)
    public Student() {}

    public Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
}