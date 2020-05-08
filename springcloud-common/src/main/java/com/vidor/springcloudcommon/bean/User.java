package com.vidor.springcloudcommon.bean;

import java.time.LocalDate;

public class User {
    private int id;
    private String name;
    private int age;
    private LocalDate dob;

    //没有回报无法反序列化的错误cannot deserialize from Object value (no delegate- or property-based Creator)
    public User() {
    }

    public User(int id, String name, int age, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
