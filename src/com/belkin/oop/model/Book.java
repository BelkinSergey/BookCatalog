package com.belkin.oop.model;

public class Book {
    private final String title;
    private final String author;
    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
    private  int availableCopies;
    public Book(String title, String author, int availableCopies) {
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
    }
    public String getTitle() {
        return title;
    }

    public  int getAvailableCopies() {
        return availableCopies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", availableCopies=" + availableCopies +
                '}';
    }
}
