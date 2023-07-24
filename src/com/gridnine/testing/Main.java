package com.gridnine.testing;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;
import com.gridnine.testing.service.FlightService;
import com.gridnine.testing.service.FlightServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        FlightBuilder flightBuilder = new FlightBuilder();

        FlightService flightService = new FlightServiceImpl();

        List<Flight> flightList = flightBuilder.createFlights();

        System.out.println("\nСписок рейсов:");
        System.out.println(flightList);
        System.out.println("\nСписок рейсов, кроме вылетевших до текущего момента времени:");
        System.out.println(flightService.withoutDepartureBeforeCurrentTime(flightList));
        System.out.println("\nСписок рейсов, кроме тех, где имеются сегменты с датой прилёта раньше даты вылета:");
        System.out.println(flightService.withoutDepartureWithIncorrectSegments(flightList));
        System.out.println("\nСписок рейсов, кроме тех, где общее время, проведённое на земле, превышает два часа:");
        System.out.println(flightService.withoutDepartureWithEarthTimeMoreThanTwoHours(flightList));

    }
}