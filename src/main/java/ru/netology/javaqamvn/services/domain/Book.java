package ru.netology.javaqamvn.services.domain;

public class Book extends Product {
    private String author;

    public Book() {

        super();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(int id, String name, int price, String author) {

        super(id, name, price);
        this.author = author;
    }
}
