package com.hotelreservation;

import com.hotelreservation.cli.MainMenu;

import java.text.ParseException;

public class HotelApplication {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        try {
            mainMenu.displayMainMenu();
        } catch(ParseException parseException) {
            System.out.println("Please enter valid date");
        }
    }
}
