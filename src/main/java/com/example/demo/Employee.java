package com.example.demo;

public class Employee {

    private int id;
    private String watchbrand;
    private String watchmodel;
    private String price;
    private String year;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWatchbrand() {
        return watchbrand;
    }

    public void setWatchbrand(String watchbrand) {
        this.watchbrand = watchbrand;
    }

    public String getWatchmodel() {
        return watchmodel;
    }

    public void setWatchmodel(String watchmodel) {
        this.watchmodel = watchmodel;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return "Employee{" + "id=" + id +
                ", watchbrand='" + watchbrand + '\'' +
                ", watchmodel='" + watchmodel + '\'' +
                ", price='" + price + '\'' +
                ", year='" + year + '\'' + '}';
    }
}