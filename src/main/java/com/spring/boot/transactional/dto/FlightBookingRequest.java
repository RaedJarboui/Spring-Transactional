package com.spring.boot.transactional.dto;

import com.spring.boot.transactional.model.PassengerInfo;
import com.spring.boot.transactional.model.PaymentInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookingRequest {
	private PassengerInfo passengerInfo;
	private PaymentInfo paymentInfo;

}
