package org.dnyanyog.services;

import java.util.List;

import org.dnyanyog.dto.FlightData;
import org.dnyanyog.dto.FlightRequest;
import org.dnyanyog.dto.FlightResponse;
import org.dnyanyog.entity.Flights;
import org.dnyanyog.repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightManagementService {

	@Autowired
	FlightRepository flightRepo;

	@Autowired
	FlightResponse flightResponse;
	
	public FlightResponse addUpdateFlight(FlightRequest request) {
		
		Flights FlightTable = new Flights();
		FlightTable.setClassofflight(request.getClassofflight());
		FlightTable.setName(request.getName());
		FlightTable.setDestination(request.getDestination());
		FlightTable.setFlightcode(request.getFlightcode());
		FlightTable.setFlightname(request.getFlightname());
		FlightTable.setJourneydate(request.getJourneydate());
		FlightTable.setJourneytime(request.getJourneytime());
		FlightTable.setPrice(request.getPrice());
		FlightTable.setSource(request.getSource());
		
		
		FlightTable=flightRepo.save(FlightTable);
		
		flightResponse.setMessage("Passenger added Successfully!!");
		flightResponse.setClassofflight(request.getClassofflight());
		flightResponse.setName(request.getName());
		flightResponse.setDestination(request.getDestination());
		flightResponse.setFlightcode(request.getFlightcode());
		flightResponse.setFlightname(request.getFlightname());
		flightResponse.setJourneydate(request.getJourneydate());
		flightResponse.setJourneytime(request.getJourneytime());
		flightResponse.setPrice(request.getPrice());
		flightResponse.setSource(request.getSource());
		flightResponse.setTicketId(request.getTicketId());
		
		return flightResponse;
	}
	
	public FlightResponse searchFlight(String flight_search) {

		List<Flights> flightTable = flightRepo.findByflightname(flight_search);

		if (flightTable.isEmpty()) {
			flightResponse.setMessage("fail");
		} else {
			Flights flight = flightTable.get(0);
			flightResponse.setMessage("Venue searched successfully !!");
			
			FlightData flightData = flightResponse.getFlightData();
			
			flightData.setClassofflight(flight.getClassofflight());
			flightData.setName(flight.getName());
			flightData.setDestination(flight.getDestination());
			flightData.setFlightcode(flight.getFlightcode());
			flightData.setFlightname(flight.getFlightname());
			flightData.setJourneydate(flight.getJourneydate());
			flightData.setJourneytime(flight.getJourneytime());
			flightData.setPrice(flight.getPrice());
			flightData.setSource(flight.getSource());
			flightData.setTicketId(flight.getTicketId());
			
		}
		return flightResponse;
	}
	
	public FlightResponse editFlight(String flight_search, FlightRequest request) {

		List<Flights> editFlight= flightRepo.findByflightname(flight_search);
		if (editFlight.isEmpty()) {
			flightResponse.setMessage("fail");
		} else {
			Flights flight = editFlight.get(0);
			flight.setClassofflight(request.getClassofflight());
			flight.setName(request.getName());
			flight.setDestination(request.getDestination());
			flight.setFlightcode(request.getFlightcode());
			flight.setFlightname(request.getFlightname());
			flight.setJourneydate(request.getJourneydate());
			flight.setJourneytime(request.getJourneytime());
			flight.setPrice(request.getPrice());
			flight.setSource(request.getSource());
			
			
			
			flightRepo.save(flight);
			
			flightResponse.setMessage("Passenger updated successfully !!");
			flightResponse.setTicketId(flight.getTicketId());
		}

		return flightResponse;
	}
	
        public FlightResponse deleteFlight(String flight_search) {
		
		List<Flights> existingFlight = flightRepo.findByflightname(flight_search);
		
		if(existingFlight.isEmpty()) {
		    flightResponse.setMessage("Passenger not found");
		}
		else {
			
			Flights flight = existingFlight.get(0);
			flightRepo.delete(flight);
			
			flightResponse.setMessage("Passenger deleted Successfully!!");
			flightResponse.setClassofflight(flight.getClassofflight());
			flightResponse.setName(flight.getName());
			flightResponse.setDestination(flight.getDestination());
			flightResponse.setFlightcode(flight.getFlightcode());
			flightResponse.setFlightname(flight.getFlightname());
			flightResponse.setJourneydate(flight.getJourneydate());
			flightResponse.setJourneytime(flight.getJourneytime());
			flightResponse.setPrice(flight.getPrice());
			flightResponse.setSource(flight.getSource());
			flightResponse.setTicketId(flight.getTicketId());
			
		}
		return flightResponse;
	}

        public List<Flights> getFlight() {
    		return flightRepo.findAll();
    	}
	
}
