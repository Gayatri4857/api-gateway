package org.dnyanyog.controller;

import java.util.List;

import org.dnyanyog.dto.FlightRequest;
import org.dnyanyog.dto.FlightResponse;
import org.dnyanyog.dto.PassengerRequest;
import org.dnyanyog.dto.PassengerResponse;
import org.dnyanyog.entity.Flights;
import org.dnyanyog.entity.Passengers;
import org.dnyanyog.services.FlightManagementService;
import org.dnyanyog.services.PassengerManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightManagementController {
	@Autowired
	FlightManagementService flightService;
	
	@PostMapping(path="/auth/flight",consumes= {"application/json","application/xml"},produces= {"application/json","application/xml"})
	public FlightResponse addUpdateFlight(@RequestBody FlightRequest flightRequest) {	
		return flightService.addUpdateFlight(flightRequest);
	}
	@GetMapping(path="/auth/flight/search/{flight_search}")
	public FlightResponse searchFlight(@PathVariable String flight_search) {
		
		return flightService.searchFlight(flight_search);
	}
	@DeleteMapping(path="/auth/flight/delete/{flight_search}")
	public FlightResponse deleteFlight(@PathVariable String flight_search) {
		return flightService.deleteFlight(flight_search);
	}
	
	@PostMapping(path="/auth/flight/update/{flight_search}")
	public FlightResponse updateFlight(@PathVariable String flight_search,@RequestBody FlightRequest flightRequest) {
		return flightService.editFlight(flight_search, flightRequest);
	}
	
	@GetMapping(path="/auth/flight")
	public List<Flights> searchAllFlights(){
		return flightService.getFlight();
	}
}
