package com.spring.boot.transactional.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional // we can add those params inside transactional annotation : Transaction
					// Rollback - Transaction Logging - ReadOnly Transactions - Isolation Level
	public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest flightRequest) {
		passengerInfoRepo.save(flightRequest.getPassengerInfo());
		if (flightRequest.getPassengerInfo().getFare() < 2000.0) // problem in case when theres exception : we have
																	// already passengerInfo already stored in DB, but
																	// theres no use when passengerInfo is stored and
																	// paymentInfo is Not ! that is why we use
																	// transactional to avoid this kind of scenarios
			throw new PassengerInfoFlareException("passenger info flare should be lower than 2000");
		paymentInfoRepo.save(flightRequest.getPaymentInfo());
		return new FlightBookingAcknowledgement("success", flightRequest.getPassengerInfo().getFare(),
				UUID.randomUUID().toString(), flightRequest.getPassengerInfo());

	}

}
