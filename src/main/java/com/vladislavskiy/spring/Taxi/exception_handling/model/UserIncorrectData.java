package com.vladislavskiy.spring.Taxi.exception_handling.model;

public class UserIncorrectData {
    private String info;

    public UserIncorrectData() {
    }
//TODO : створити підпапку модел і збати це туда +
    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
