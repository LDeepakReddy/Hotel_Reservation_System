package com.blz.hotelreservationsystem;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationSystemTest {
    @Test
    public void givenHotel_whenDetailsEntered_ForRegularCustomers_ShouldReturnTrue() {
        HotelReservationSystem hotels = new HotelReservationSystem();
        boolean hotel_1 = hotels.addHotel("Hotel-1", "LakeWood", 110, 90);
        Assert.assertEquals(true, hotel_1);
        boolean hotel_2 = hotels.addHotel("Hotel-2", "BridgeWood", 160, 60);
        Assert.assertEquals(true, hotel_2);
        boolean hotel_3 = hotels.addHotel("Hotel-3", "RidgeWood", 220, 150);
        Assert.assertEquals(true, hotel_3);
        hotels.displayHotel();
    }

}
