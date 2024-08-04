package org.dnyanyog.controller;

import java.util.List;

import org.dnyanyog.dto.PassengerRequest;
import org.dnyanyog.dto.PassengerResponse;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.entity.Passengers;
import org.dnyanyog.entity.Users;
import org.dnyanyog.services.PassengerManagementService;
import org.dnyanyog.services.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassengerManagementController {
	@Autowired
	PassengerManagementService passengerService;
	
	@PostMapping(path="/auth/passenger",consumes= {"application/json","application/xml"},produces= {"application/json","application/xml"})
	public PassengerResponse addUpdatePassenger(@RequestBody PassengerRequest passengerRequest) {	
		return passengerService.addUpdatePassenger(passengerRequest);
	}
	@GetMapping(path="/auth/passenger/search/{passenger_search}")
	public PassengerResponse searchPassenger(@PathVariable String passenger_search) {
		
		return passengerService.searchPassenger(passenger_search);
	}
	@DeleteMapping(path="/auth/passenger/delete/{passenger_search}")
	public PassengerResponse deletePassenger(@PathVariable String passenger_search) {
		return passengerService.deletePassenger(passenger_search);
	}
	
	@PostMapping(path="/auth/passenger/update/{passenger_search}")
	public PassengerResponse updatePassenger(@PathVariable String passenger_search,@RequestBody PassengerRequest passengerRequest) {
		return passengerService.editPassenger(passenger_search, passengerRequest);
	}
	
	@GetMapping(path="/auth/passenger")
	public List<Passengers> searchAllPassengers(){
		return passengerService.getPassenger();
	}	
}
