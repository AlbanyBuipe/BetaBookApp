package com.nexus.domain;

public class City {

    // Attributes
    private String name;
    private String country;

    // Constructor


    public City() {
    }

    public City(String Name) {
        name = Name;
    }

    public City(String Name, String Country) {
        this(Name);
        country = Country;
    }

    public String getCityName() {
        return name;
    }

    public void setCityName(String Name) {
        name = Name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String Country) {
        country = Country;
    }

    @Override
    public String toString() {
        return name;
    }
}
