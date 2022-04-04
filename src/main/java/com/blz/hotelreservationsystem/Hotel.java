package com.blz.hotelreservationsystem;

public class Hotel {
    String hotelNumber;
    String hotelName;
    int weekDayRates;
    int weekEndRates;

    public Hotel() {

    }

    public Hotel(String hotelName, int weekDayRates, int weekEndRates) {
        this.hotelNumber = hotelNumber;
        this.hotelName = hotelName;
        this.weekDayRates = weekDayRates;
        this.weekEndRates = weekEndRates;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getWeekDayRates() {
        return weekDayRates;
    }

    public void setWeekDayRates(int weekDayRates) {
        this.weekDayRates = weekDayRates;
    }

    public int getWeekEndRates() {
        return weekEndRates;
    }

    public void setWeekEndRates(int weekEndRates) {
        this.weekEndRates = weekEndRates;
    }

    public String getHotelNumber() {
        return hotelNumber;
    }

    public void setHotelNumber(String hotelNumber) {
        this.hotelNumber = hotelNumber;
    }
}
