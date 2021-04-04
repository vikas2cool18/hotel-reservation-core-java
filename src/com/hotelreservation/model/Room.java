package com.hotelreservation.model;

import java.util.Objects;

public class Room implements IRoom {
    private double price;
    private String roomNumber;
    private RoomType roomType;
    private boolean isFree;

    public Room(double price, String roomNumber, RoomType roomType, boolean isFree) {
        this.price = price;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isFree = isFree;
    }

    @Override
    public String toString() {
        return "Room{" +
                "price=" + price +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomType=" + roomType +
                ", isFree=" + isFree +
                '}';
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean isFree() {
        return isFree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomNumber, room.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }
}
