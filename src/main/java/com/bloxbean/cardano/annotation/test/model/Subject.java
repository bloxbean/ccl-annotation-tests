package com.bloxbean.cardano.annotation.test.model;

import com.bloxbean.cardano.client.plutus.annotation.Constr;

import java.util.Arrays;
import java.util.Optional;

@Constr
public class Subject {
    private String name;
    private int marks;
    private byte[] logo;
    private Optional<byte[]> id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public Optional<byte[]> getId() {
        return id;
    }

    public void setId(Optional<byte[]> id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                ", logo=" + Arrays.toString(logo) +
                ", id=" + id +
                '}';
    }
}
