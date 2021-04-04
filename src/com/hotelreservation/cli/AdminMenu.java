package com.hotelreservation.cli;

import com.hotelreservation.api.AdminResource;
import com.hotelreservation.api.HotelResource;
import com.hotelreservation.model.IRoom;
import com.hotelreservation.model.Room;
import com.hotelreservation.model.RoomType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AdminMenu {
    void displayAdminMenu() throws ParseException {
        AdminResource adminResource = new AdminResource();
        HotelResource hotelResource = new HotelResource();
        String option = null;
        String userInput = null;
        do {
            System.out.println("1. See All Customers");
            System.out.println("2. See All Rooms");
            System.out.println("3. See All Reservations");
            System.out.println("4. Add a Room");
            System.out.println("5. Back to Main Menu");
            Scanner in = new Scanner(System.in);
            option = in.nextLine();
            switch (option) {
                case "1":
                    System.out.println(adminResource.getAllCustomers());
                    break;
                case "2":
                    System.out.println(adminResource.getAllRooms());
                    break;
                case "3":
                    adminResource.displayAllReservations();
                    break;
                case "4":
                    do {
                        System.out.println("Enter room number");
                        String roomNo = in.nextLine();
                        System.out.println("Enter room type SINGLE OR DOUBLE");
                        String roomType = in.nextLine();
                        RoomType roomTypeEnum = RoomType.valueOf(roomType);
                        System.out.println("Enter room price");
                        String price = in.nextLine();
                        Double priceDouble = Double.parseDouble(price);
                        IRoom room = new Room(priceDouble, roomNo, roomTypeEnum, true);
                        adminResource.createARoom(room);
                        System.out.println("Would you like to add another room y/n");
                        userInput = in.nextLine();
                    } while(!userInput.equalsIgnoreCase("n"));
                    break;
                case "5":
                    return;
                default:
                    System.out.println("please provide valid input");
            }
        } while(option != "5");
    }
}
