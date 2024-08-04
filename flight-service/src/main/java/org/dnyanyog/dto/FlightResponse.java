package org.dnyanyog.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class FlightResponse {
	private String message;
	private int TicketId;
	private String source;
	private String destination;
	private String classofflight;
	private String price;
	private String flightcode;
	private String flightname;
	private String journeydate;
	private String journeytime;
	private String name;
	
	@Autowired
	private FlightData flightData;
	
	
	public FlightData getFlightData() {
		return flightData;
	}
	public void setFlightData(FlightData flightData) {
		this.flightData = flightData;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getTicketId() {
		return TicketId;
	}
	public void setTicketId(int ticketId) {
		TicketId = ticketId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getClassofflight() {
		return classofflight;
	}
	public void setClassofflight(String classofflight) {
		this.classofflight = classofflight;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getFlightcode() {
		return flightcode;
	}
	public void setFlightcode(String flightcode) {
		this.flightcode = flightcode;
	}
	public String getFlightname() {
		return flightname;
	}
	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}
	public String getJourneydate() {
		return journeydate;
	}
	public void setJourneydate(String journeydate) {
		this.journeydate = journeydate;
	}
	public String getJourneytime() {
		return journeytime;
	}
	public void setJourneytime(String journeytime) {
		this.journeytime = journeytime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
