package com.nexus.domain;

public class Book {

    // Attributes
    private String title;
    private Author author;
    private int year;
    private Publisher publisher;
    private int edition;
    private boolean status;

    public Book() {
    }

    public Book(String Title) {
        title = Title;
    }

    public Book(String Title, Author authorX) {
        title = Title;
        author = authorX;
    }

    // Methods: Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        title = Title;
    }

    public String getAuthor() {
        return author.toString();
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int Year) {
        year = Year;
    }

    public String getPublisher() {
        return publisher.toString();
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getBookCity() {
        return publisher.getCity();
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int Edition) {
        edition = Edition;
    }

    public boolean read() {
        return status;
    }

    public void read(boolean Status) {
        status = Status;
    }
}
