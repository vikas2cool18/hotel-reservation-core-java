package com.hotelreservation.api;

import com.hotelreservation.model.Customer;
import com.hotelreservation.model.IRoom;
import com.hotelreservation.model.Reservation;
import com.hotelreservation.service.CustomerService;
import com.hotelreservation.service.ReservationService;
import com.hotelreservation.service.RoomService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    private CustomerService customerService = new CustomerService();
    private ReservationService reservationService = new ReservationService();
    private RoomService roomService = new RoomService();
    public Customer getCustomer(String email) {
       return customerService.getCustomer(email);
    }
    public void createCustomer(String firstName, String lastName, String email) {
        customerService.addCustomer(firstName, lastName, email);
    }
    public IRoom getRoom(String roomNumber) {
        return roomService.getARoom(roomNumber);
    }
    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        Customer customer = customerService.getCustomer(customerEmail);
        if(null != customer) {
            return reservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
        }
        return null;
    }
    public Collection<Reservation> getCustomerReservations(String customerEmail) {
        return reservationService.getCustomerReservation(customerService.getCustomer(customerEmail));
    }
    public Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate) {
        return roomService.findRooms(checkInDate, checkOutDate);
    }
}
