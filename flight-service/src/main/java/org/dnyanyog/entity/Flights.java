package org.dnyanyog.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@Component
public class Flights {

	@GeneratedValue
	@Id
	@Column
	private int TicketId;
	@Column
	private String source;
	@Column
	private String destination;
	@Column
	private String classofflight;
	@Column
	private String price;
	@Column
	private String flightcode;
	@Column
	private String flightname;
	@Column
	private String journeydate;
	@Column
	private String journeytime;
	@Column
	private String name;
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
