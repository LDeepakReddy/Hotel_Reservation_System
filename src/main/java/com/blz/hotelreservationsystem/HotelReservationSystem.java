package com.blz.hotelreservationsystem;

import java.util.HashMap;
import java.util.Map;

public class HotelReservationSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to the Hotel Reservation System Program");

    }

    Map<String, Hotel> hotelMap = new HashMap<String, Hotel>();

    public boolean addHotel(String hotelNumber, String hotelName, int weekDayRates, int weekEndRates) {
        Hotel hotel = new Hotel();
        hotel.setHotelNumber(hotelNumber);
        hotel.setHotelName(hotelName);
        hotel.setWeekDayRates(weekDayRates);
        hotel.setWeekEndRates(weekEndRates);
        hotelMap.put(hotelNumber, hotel);


        return true;
    }

    public void displayHotel() {
        for (Map.Entry<String, Hotel> hotelEntry : hotelMap.entrySet()) {
            String key = hotelEntry.getKey();
            Hotel value = hotelEntry.getValue();
            System.out.println("\nKey : " + key);
            System.out.println(" \n Hotel Name : " + value.hotelName + " \nRates On weekdays : " + value.weekDayRates +
                    "\n Rates on Weekwnds : " + value.weekEndRates);
        }
    }


}