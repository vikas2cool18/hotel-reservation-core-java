package com.hotelreservation.cli;

import com.hotelreservation.api.AdminResource;
import com.hotelreservation.api.HotelResource;
import com.hotelreservation.model.IRoom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public  void displayMainMenu() throws ParseException {
        AdminResource adminResource = new AdminResource();
        HotelResource hotelResource = new HotelResource();
        AdminMenu adminMenu = new AdminMenu();
        String option = null;
        do {
            System.out.println("1. Find and reserve a room");
            System.out.println("2. See my reservation");
            System.out.println("3. Create an account");
            System.out.println("4. Admin");
            System.out.println("5. Exit");
            Scanner in = new Scanner(System.in);
            option = in.nextLine();
            switch(option) {
                case "1" :
                    System.out.println("Enter checkIn Date in the format yyyy-MM-dd");
                    String checkInString = in.nextLine();
                    Date checkInDate=new SimpleDateFormat(DATE_FORMAT).parse(checkInString);
                    Date currentDate = new Date();
                    if(checkInDate.before(currentDate)) {
                        throw new IllegalArgumentException();
                    }
                    System.out.println("Enter checkOut Date in the format yyyy-MM-dd");
                    String checkOutString = in.nextLine();
                    Date checkOutDate=new SimpleDateFormat(DATE_FORMAT).parse(checkOutString);
                    if(checkOutDate.before(checkInDate) || checkOutDate.before(currentDate)) {
                        throw new IllegalArgumentException();
                    }
                    System.out.println(hotelResource.findARoom(checkInDate, checkOutDate));
                    System.out.println("Would you like to book a room? y/n");
                    String choice = in.nextLine();
                    if(!choice.equalsIgnoreCase("n")) {
                        System.out.println("Do you have an account with us? y/n");
                        String accountOption = in.nextLine();
                        if(!accountOption.equalsIgnoreCase("n")) {
                            System.out.println("Enter your email");
                            String email = in.nextLine();
                            System.out.println("What room would you like to book");
                            String roomNumber = in.nextLine();
                            IRoom room = hotelResource.getRoom(roomNumber);
                            System.out.println(hotelResource.bookARoom(email, room, checkInDate, checkOutDate));
                        }
                    }
                    break;
                case "2" :
                    System.out.println("Please enter your email");
                    String email=in.nextLine();
                    System.out.println(hotelResource.getCustomerReservations(email));
                    break;
                case "3":
                    System.out.println("Enter your first name");
                    String firstName=in.nextLine();
                    System.out.println("Enter your last name");
                    String lastName=in.nextLine();
                    System.out.println("Enter your email");
                    String customerEmail=in.nextLine();
                    hotelResource.createCustomer(firstName, lastName, customerEmail);
                    break;
                case "4":
                    adminMenu.displayAdminMenu();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Please provide valid input");
            }
        } while(option != "5");
    }
}
