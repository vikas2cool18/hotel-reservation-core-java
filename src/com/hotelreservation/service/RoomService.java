package com.hotelreservation.service;

import com.hotelreservation.model.IRoom;
import com.hotelreservation.model.Room;
import com.hotelreservation.model.RoomType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

public class RoomService {

    private static Collection<IRoom> rooms = new ArrayList<>();
    public void addARoom(double price, String roomNumber, RoomType roomType, boolean isFree) {
        IRoom room = new Room(price, roomNumber, roomType, isFree);
        rooms.add(room);
    }
    public IRoom getARoom(String roomNumber) {
        for(IRoom room : rooms) {
            if(roomNumber.equalsIgnoreCase(room.getRoomNumber())) {
                return room;
            }
        }
        return null;
    }
    public Collection<IRoom> getAllRooms() {
        return rooms;
    }
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        return rooms.stream().filter(room-> room.isFree()).collect(Collectors.toList());
    }
}
