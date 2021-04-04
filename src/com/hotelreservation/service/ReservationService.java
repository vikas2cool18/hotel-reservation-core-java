package com.hotelreservation.service;

import com.hotelreservation.model.Customer;
import com.hotelreservation.model.IRoom;
import com.hotelreservation.model.Reservation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

public class ReservationService {
    private static Collection<Reservation> reservations = new ArrayList<>();
    private RoomService roomService = new RoomService();
    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        if(!reservations.stream().anyMatch(reservation -> reservation.getRoom().equals(room))) {
            Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
            reservations.add(reservation);
            return reservation;
        }
        System.out.println("The room with room number " + room.getRoomNumber() + " is already reserved");
       return null;
    }
    public Collection<Reservation> getCustomerReservation(Customer customer) {
        return reservations.stream().filter(r-> r.getCustomer().equals(customer)).collect(Collectors.toList());
    }
    public void printAllReservation() {
        for(Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}
