package com.example;

import com.example.view.HomePage;

import javafx.application.Application;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("com.example.config.FirebaseConfig");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Application.launch(HomePage.class, args);
        System.out.println("Hello world!");
    }
}