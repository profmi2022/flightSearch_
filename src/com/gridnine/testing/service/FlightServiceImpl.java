package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightServiceImpl implements FlightService{

    @Override
    public List<Flight> withoutDepartureBeforeCurrentTime(List<Flight> flights){

        List<Flight> flightList = new ArrayList<>();
        for (Flight flight : flights) {
            if (!flight.getSegments().isEmpty()
                    && flight.getSegments().get(0).getDepartureDate().isBefore(LocalDateTime.now())) {
            }else {
                flightList.add(flight);
            }
        }
        return flightList;
    }

    @Override
    public List<Flight> withoutDepartureWithIncorrectSegments(List<Flight> flights) {
        List<Flight> flightList = new ArrayList<>();
        for (Flight flight : flights)
            nextFlight:{
                for (Segment segment : flight.getSegments()) {
                    if (segment.getArrivalDate().isBefore(segment.getDepartureDate())) {
                        break nextFlight;
                    }
                }
                flightList.add(flight);
            }
        return flightList;
    }

    @Override
    public List<Flight> withoutDepartureWithEarthTimeMoreThanTwoHours(List<Flight> flights) {
        List<Flight> flightList = new ArrayList<>();
        Duration EarthTime;
        for (Flight flight : flights) {
            EarthTime = Duration.ofSeconds(0);
            if (flight.getSegments().size() > 1) {
                for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                    EarthTime = EarthTime.plus(Duration.between(flight.getSegments().get(i).getArrivalDate(),
                            flight.getSegments().get(i + 1).getDepartureDate()));
                }
            }
            if (EarthTime.toHours() <= 2) {
                flightList.add(flight);
            }
        }
        return flightList;
    }
}

