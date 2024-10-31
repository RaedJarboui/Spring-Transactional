package com.spring.boot.transactional.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.transactional.dto.FlightBookingAcknowledgement;
import com.spring.boot.transactional.dto.FlightBookingRequest;
import com.spring.boot.transactional.exception.PassengerInfoFlareException;
import com.spring.boot.transactional.repo.PassengerInfoRepository;
import com.spring.boot.transactional.repo.PaymentInfoRepository;

@Service
public class FlightBookingService {

	@Autowired
	private PassengerInfoRepository passengerInfoRepo;
	@Autowired
	private PaymentInfoRepository paymentInfoRepo;

	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest flightRequest) {
		passengerInfoRepo.save(flightRequest.getPassengerInfo());
		if (flightRequest.getPassengerInfo().getFare() < 2000.0)
			throw new PassengerInfoFlareException("passenger info flare should be lower than 2000");
		paymentInfoRepo.save(flightRequest.getPaymentInfo());
		return new FlightBookingAcknowledgement("success", flightRequest.getPassengerInfo().getFare(),
				UUID.randomUUID().toString(), flightRequest.getPassengerInfo());

	}

}
