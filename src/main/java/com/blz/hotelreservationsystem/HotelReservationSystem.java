package com.blz.hotelreservationsystem;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class HotelReservationSystem {

    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");
        HotelReservationSystem hotelReservation = new HotelReservationSystem();
        hotelReservation.addHotel("Lakewood", 3, 110, 90);
        hotelReservation.addHotel("Bridgewood", 4, 150, 50);
        hotelReservation.addHotel("Ridgewood", 5, 220, 150);
        hotelReservation.displayHotel();

        LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);
        LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);
        String hotelName = hotelReservation.getCheapestHotel(startDate, endDate);
        System.out.println("The cheapest hotel is : \n " + hotelName);
    }


    ArrayList<Hotel> hotelList = new ArrayList<Hotel>();

    public void addHotel(String hotelName, int rating, double weekdayRegularCustomerCost, double weekendRegularCustomerCost) {
        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelName);
        hotel.setRating(rating);
        hotel.setWeekdayRegularCustomerCost(weekdayRegularCustomerCost);
        hotel.setWeekendRegularCustomerCost(weekendRegularCustomerCost);
        hotelList.add(hotel);
    }

    public void displayHotel() {
        System.out.println(hotelList);

    }

    public int getHotelListSize() {
        return hotelList.size();
    }

    public void printHotelList() {
        System.out.println(hotelList);
    }

    public ArrayList<Hotel> getHotelList() {
        return hotelList;
    }

    public String getCheapestHotel(LocalDate startDate, LocalDate endDate) {

        int numberOfDays = (int) ChronoUnit.DAYS.between(startDate, endDate);
        int weekends = 0;

        while (startDate.compareTo(endDate) != 0) {
            switch (DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK))) {
                case SATURDAY:
                    ++weekends;
                    break;
                case SUNDAY:
                    ++weekends;
                    break;
            }
            startDate = startDate.plusDays(1);
        }

        final int weekdaysNumber = numberOfDays - weekends;
        final int weekendsNumber = weekends;

        final double cheapestPrice = hotelList.stream()
                .mapToDouble(hotel -> ((hotel.getWeekendRegularCustomerCost() * weekendsNumber) + hotel.getWeekdayRegularCustomerCost() * weekdaysNumber))
                .min()
                .orElse(Double.MAX_VALUE);

        ArrayList<Hotel> cheapestHotel = hotelList.stream()
                .filter(hotel -> (hotel.getWeekendRegularCustomerCost() * weekendsNumber + hotel.getWeekdayRegularCustomerCost() * weekdaysNumber) == cheapestPrice)
                .collect(Collectors.toCollection(ArrayList::new));

        if (cheapestPrice != Double.MAX_VALUE) {

            System.out.println("Cheapest Hotel : \n" + cheapestHotel.get(0).getHotelName() + ", Total Rates: " + cheapestPrice);
            return cheapestHotel.get(0).getHotelName();
        }
        return null;
    }

}
