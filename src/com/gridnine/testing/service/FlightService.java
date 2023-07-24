package com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;

import java.util.List;

public interface FlightService {

    List<Flight> withoutDepartureBeforeCurrentTime(List<Flight> flights);
    List<Flight> withoutDepartureWithIncorrectSegments(List<Flight> flights);
    List<Flight> withoutDepartureWithEarthTimeMoreThanTwoHours(List<Flight> flights);

}
