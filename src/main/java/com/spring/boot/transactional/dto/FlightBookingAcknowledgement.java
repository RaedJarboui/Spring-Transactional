package com.spring.boot.transactional.dto;

import com.spring.boot.transactional.model.PassengerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingAcknowledgement {
	private String status;
	private double totalFare;
	private String pnrNo;
	private PassengerInfo passengerInfo;

}
