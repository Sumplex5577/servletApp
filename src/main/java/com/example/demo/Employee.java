package com.example.demo;

public class Employee {

    private int id;
    private String name;
    private String country;
    private String email;
    private String telnumber;
    private String surname;
    private String age;

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
         return "Employee{" + "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", telnumber='" + telnumber + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age + '}';
    }
}