package com.blz.hotelreservationsystem;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class HotelReservationSystemTest {
    HotelReservationSystem hotels = new HotelReservationSystem();

    @Test
    public void givenHotel_whenDetailsEntered_ForRegularCustomers_ShouldReturnTrue() {

        boolean hotel1 = hotels.addHotel("Hotel-1", "LakeWood", 110, 90);
        Assert.assertEquals(true, hotel1);
        boolean hotel2 = hotels.addHotel("Hotel-2", "BridgeWood", 160, 60);
        Assert.assertEquals(true, hotel2);
        boolean hotel3 = hotels.addHotel("Hotel-3", "RidgeWood", 220, 150);
        Assert.assertEquals(true, hotel3);
        hotels.displayHotel();
    }

    @Test
    public void givenRangeOfDates_WithRatesOnWeekdaysAndWeekends_ShouldReturnCheapestHotel() {

        hotels.addHotel("Hotel-1", "LakeWood", 110, 90);
        hotels.addHotel("Hotel-2", "BridgeWood", 160, 60);
        hotels.addHotel("Hotel-3", "RidgeWood", 220, 150);

        LocalDate startDate = LocalDate.of(2020, 03, 16);
        LocalDate endDate = LocalDate.of(2020, 03, 17);
        Hotel hotel = hotels.cheapestHotel(startDate, endDate);
        Assert.assertEquals("LakeWood", hotel.getHotelName());
        System.out.println("Cheapest hotel is " + hotel.getHotelName());

    }

}
