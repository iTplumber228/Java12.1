package ru.netology.javaqamvn.services.repository;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {

        super(msg);
    }

}
