package com.roombooking.publisher;

import javax.xml.ws.Endpoint;
import com.roombooking.generator.RoomGenerator;
import com.roombooking.service.RoomBookingServiceImpl;


public class RoomBookingServicePublisher {
	public static void main(String[] args) {
		RoomGenerator.generateManagedRooms();

		System.out.println("Server started...");

		Endpoint.publish("http://127.0.0.1:9876/roomBooking", new RoomBookingServiceImpl());
	}
}
