package com.cg.flightsearchapi.service;



import java.util.List;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightsearchapi.entity.Flights;
import com.cg.flightsearchapi.exception.FlightNotFoundException;
import com.cg.flightsearchapi.repository.FlightRepository;

@Service
public class FlightSearchServiceImpl implements FlightSearchService {
	
	@Autowired
    FlightRepository flightRepo;
	
	@Override
	public List<Flights> viewFlights() {
	
		return flightRepo.findAll();
	
	}

	@Override
	public List<Flights> getFlightBySourceDestinationDate(String source, String destination, String date) {
		
		List<Flights> flights = flightRepo.findBySourceDestinationDate(source, destination, date);
		
		if(flights.size() != 0) {
			return flights;
		}
		else {
			throw new FlightNotFoundException("There is no flight between "+source+" to "+destination+" on "+date);
		}
	}

	@Override
	public String addFlight(Flights flight) throws Exception {
		Random rand = new Random(); 
		int random = rand.nextInt(1000); 
		//generating flight
		flight.setFlightId(random+""+ (int)(flight.getFare()/random));
		if(flightRepo.save(flight) != null) {
			return "flight "+flight.getFlightName()+"is UP!";
		}
		else {
			throw new Exception("fail to add flight");
		}
		
		
	}

}
