package com.ioprogramming.day02jsondata.practiceproblems.tojsonarray;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

class Student {
    String name;
    int age;
    List<String> subjects;

    public Student(String name, int age, List<String> subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    // Getters required for Jackson serialization
    public String getName() { return name; }
    public int getAge() { return age; }
    public List<String> getSubjects() { return subjects; }
}