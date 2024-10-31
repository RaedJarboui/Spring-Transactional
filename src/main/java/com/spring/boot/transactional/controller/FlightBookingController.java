package com.spring.boot.transactional.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.transactional.dto.FlightBookingAcknowledgement;
import com.spring.boot.transactional.dto.FlightBookingRequest;
import com.spring.boot.transactional.service.FlightBookingService;

@RestController
@RequestMapping("/flights")
public class FlightBookingController {
	@Autowired
	private FlightBookingService flightService;

	@PostMapping("/save")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest flightRequest) {
		return flightService.bookFlightTicket(flightRequest);
	}

}
