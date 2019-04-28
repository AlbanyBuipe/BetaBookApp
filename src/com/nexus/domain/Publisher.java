package com.nexus.domain;

public class Publisher {

    // Attributes
    private String name;
    private City city;

    // Constructors
    public Publisher() {
    }

    public Publisher(String Name) {
        name = Name;
    }

    public Publisher(String Name, City City) {
        this(Name);
        city = City;
    }

    public String getPublisherName() {
        return name;
    }

    public void setPublisherName(String Name) {
        name = Name;
    }

    public String getCity() {
        return city.toString();
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return name;
    }
}
