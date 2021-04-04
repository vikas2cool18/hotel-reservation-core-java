package com.hotelreservation.model;

public class FreeRoom extends Room {

    public FreeRoom(double price, String roomNumber, RoomType roomType, boolean isFree) {
        super(0, roomNumber, roomType, isFree);
    }

    @Override
    public String toString() {
        return "FreeRoom{} " + super.toString();
    }
}
