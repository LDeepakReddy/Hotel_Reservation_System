package com.blz.hotelreservationsystem;

import java.security.KeyStore;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class HotelReservationSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to the Hotel Reservation System Program");
    }

    Map<String, Hotel> hotelMap = new HashMap<>();

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

    public Hotel cheapestHotelOnWeekDay(LocalDate startDate, LocalDate endDate) {
        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        Optional<Hotel> hotelStream = hotelMap.values().stream().limit(numOfDaysBetween).min(Comparator.comparing(Hotel::getWeekDayRates));
        System.out.println(LocalDate.of(2020, 9, 11).getDayOfWeek());
        System.out.println(LocalDate.of(2020, 9, 12).getDayOfWeek());

        return hotelStream.get();

    }
    public Hotel cheapestHotelOnWeekend(LocalDate startDate, LocalDate endDate) {
        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        Optional<Hotel> hotelStream = hotelMap.values().stream().limit(numOfDaysBetween).min(Comparator.comparing(Hotel::getWeekEndRates));
        System.out.println(LocalDate.of(2020, 9, 11).getDayOfWeek());
        System.out.println(LocalDate.of(2020, 9, 12).getDayOfWeek());

        return hotelStream.get();

    }


}