package com.cg.flightsearchapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightsearchapi.entity.Flights;
import com.cg.flightsearchapi.exception.NullValueException;
import com.cg.flightsearchapi.service.FlightSearchService;




@RestController
@RequestMapping
public class FlightController {

	@Autowired
	FlightSearchService flightSearchService;
	
	@GetMapping("/viewFlights")
	public List<Flights> getAllFlights() {
       return flightSearchService.viewFlights();
    }
	
	@GetMapping("/getFlightBySourceDestinationDate")
	public List<Flights> getFlightBySourceDestinationDate(@RequestParam String source , @RequestParam String destination, @RequestParam String date) {
		if (source.equals("") || destination.equals("") || date.equals("")) {
			throw new NullValueException("Please provide correct details!");
		}
		return flightSearchService.getFlightBySourceDestinationDate(source, destination, date);
	}
	
	@PostMapping("/addflight")
	public String addFlight(@RequestBody Flights flight) throws Exception {
		return flightSearchService.addFlight(flight);
	}
	
	
	
	
	
}
