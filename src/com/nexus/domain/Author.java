package com.nexus.domain;

public class Author {

    // Attributes
    private String firstName;
    private String middleName;
    private String lastName;

    public Author() {
    }

    public Author(String FirstName) {
        firstName = FirstName;
    }

    public Author(String FirstName, String LastName) {
        this(FirstName);
        lastName = LastName;
    }

    public Author(String FirstName, String MiddleName, String LastName) {
        this(FirstName);
        middleName = MiddleName;
        lastName = LastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String FirstName) {
        firstName = FirstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String MiddleName) {
        middleName = MiddleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String LastName) {
        lastName = LastName;
    }

    public boolean isMiddleNull() {
        if (middleName == null)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        if (!isMiddleNull())
            return firstName + " " + middleName + " " + lastName;
        else
            return firstName + " " + lastName;
    }

}
