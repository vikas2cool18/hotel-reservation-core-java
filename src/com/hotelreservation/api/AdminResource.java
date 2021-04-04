package com.hotelreservation.api;

import com.hotelreservation.model.Customer;
import com.hotelreservation.model.IRoom;
import com.hotelreservation.model.RoomType;
import com.hotelreservation.service.CustomerService;
import com.hotelreservation.service.ReservationService;
import com.hotelreservation.service.RoomService;

import java.util.Collection;
import java.util.List;

public class AdminResource {
    private static CustomerService customerService = new CustomerService();
    private static ReservationService reservationService = new ReservationService();
    private static RoomService roomService = new RoomService();
    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }
    public Collection<IRoom> getAllRooms() {
        return roomService.getAllRooms();
    }
    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    public void displayAllReservations() {
        reservationService.printAllReservation();
    }
    public void createARoom(IRoom room) {
        roomService.addARoom(room.getRoomPrice(), room.getRoomNumber(), room.getRoomType(), room.isFree());
    }
}
