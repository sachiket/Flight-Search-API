package com.cg.flightsearchapi.service;

import java.util.List;

import com.cg.flightsearchapi.entity.Flights;



public interface FlightSearchService {

	public List<Flights> viewFlights();

	public  List<Flights> getFlightBySourceDestinationDate(String source, String destination, String date);

	public String addFlight(Flights flight) throws Exception;

	
}
