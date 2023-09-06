package com.bloxbean.cardano.annotation.test.model;

import com.bloxbean.cardano.client.plutus.annotation.Constr;

import java.util.List;
import java.util.Optional;

@Constr
public class Student {
    private String name;
    private int age;
    private String gender;
    private List<Subject> subjects;
    private Optional<String> hobby;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Optional<String> getHobby() {
        return hobby;
    }

    public void setHobby(Optional<String> hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", subjects=" + subjects +
                ", hobby=" + hobby +
                '}';
    }
}
