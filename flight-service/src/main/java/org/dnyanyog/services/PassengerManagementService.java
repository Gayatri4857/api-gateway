package org.dnyanyog.services;

import java.util.List;

import org.dnyanyog.dto.PassengerData;
import org.dnyanyog.dto.PassengerRequest;
import org.dnyanyog.dto.PassengerResponse;
import org.dnyanyog.entity.Passengers;
import org.dnyanyog.repo.PassengersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerManagementService {
	@Autowired
	PassengersRepository passengerRepo;

	@Autowired
	PassengerResponse passengerResponse;
	
	public PassengerResponse addUpdatePassenger(PassengerRequest request) {
		
		Passengers passengersTable = new Passengers();
		passengersTable.setUsername(request.getUsername());
		passengersTable.setName(request.getName());
		passengersTable.setAge(request.getAge());
		passengersTable.setAddress(request.getAddress());
		passengersTable.setDateofbirth(request.getDateofbirth());
		passengersTable.setEmailid(request.getEmailid());
		passengersTable.setNationality(request.getNationality());
		passengersTable.setPhone(request.getPhone());
		passengersTable.setPassportno(request.getPassportno());
		passengersTable.setGender(request.getGender());
		
		passengersTable=passengerRepo.save(passengersTable);
		
		passengerResponse.setMessage("Passenger added Successfully!!");
		passengerResponse.setUsername(request.getUsername());
		passengerResponse.setName(request.getName());
		passengerResponse.setAge(request.getAge());
		passengerResponse.setAddress(request.getAddress());
		passengerResponse.setDateofbirth(request.getDateofbirth());
		passengerResponse.setEmailid(request.getEmailid());
		passengerResponse.setNationality(request.getNationality());
		passengerResponse.setPhone(request.getPhone());
		passengerResponse.setPassportno(request.getPassportno());
		passengerResponse.setGender(request.getGender());
		
		return passengerResponse;
	}
	
	public PassengerResponse searchPassenger(String passenger_search) {

		List<Passengers> passengerTable = passengerRepo.findByusername(passenger_search);

		if (passengerTable.isEmpty()) {
			passengerResponse.setMessage("fail");
		} else {
			Passengers passenger = passengerTable.get(0);
			passengerResponse.setMessage("Venue searched successfully !!");
			
			PassengerData passengerData = passengerResponse.getPassengerData();
			
			passengerData.setUsername(passenger.getUsername());
			passengerData.setName(passenger.getName());
			passengerData.setAge(passenger.getAge());
			passengerData.setAddress(passenger.getAddress());
			passengerData.setDateofbirth(passenger.getDateofbirth());
			passengerData.setEmailid(passenger.getEmailid());
			passengerData.setNationality(passenger.getNationality());
			passengerData.setPhone(passenger.getPhone());
			passengerData.setPassportno(passenger.getPassportno());
			passengerData.setGender(passenger.getGender());

		}
		return passengerResponse;
	}
	
	public PassengerResponse editPassenger(String passenger_search, PassengerRequest request) {

		List<Passengers> editPassenger= passengerRepo.findByusername(passenger_search);
		if (editPassenger.isEmpty()) {
			passengerResponse.setMessage("fail");
		} else {
			Passengers passenger = editPassenger.get(0);
			passenger.setUsername(request.getUsername());
			passenger.setName(request.getName());
			passenger.setAge(request.getAge());
			passenger.setAddress(request.getAddress());
			passenger.setDateofbirth(request.getDateofbirth());
			passenger.setEmailid(request.getEmailid());
			passenger.setNationality(request.getNationality());
			passenger.setPhone(request.getPhone());
			passenger.setPassportno(request.getPassportno());
			passenger.setGender(request.getGender());

			
			passengerRepo.save(passenger);
			
			passengerResponse.setMessage("Passenger updated successfully !!");
		}

		return passengerResponse;
	}
	
        public PassengerResponse deletePassenger(String passenger_search) {
		
		List<Passengers> existingPassenger = passengerRepo.findByusername(passenger_search);
		
		if(existingPassenger.isEmpty()) {
			passengerResponse.setMessage("Passenger not found");
		}
		else {
			
			Passengers passenger = existingPassenger.get(0);
			passengerRepo.delete(passenger);
			
			passengerResponse.setMessage("Passenger deleted Successfully!!");
			passengerResponse.setUsername(passenger.getUsername());
			passengerResponse.setName(passenger.getName());
			passengerResponse.setAge(passenger.getAge());
			passengerResponse.setAddress(passenger.getAddress());
			passengerResponse.setDateofbirth(passenger.getDateofbirth());
			passengerResponse.setEmailid(passenger.getEmailid());
			passengerResponse.setNationality(passenger.getNationality());
			passengerResponse.setPhone(passenger.getPhone());
			passengerResponse.setPassportno(passenger.getPassportno());
			passengerResponse.setGender(passenger.getGender());
		}
		return passengerResponse;
	}

        public List<Passengers> getPassenger() {
    		return passengerRepo.findAll();
    	}
	
	
}
