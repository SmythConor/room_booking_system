package com.roombooking.publisher;

import javax.xml.ws.Endpoint;
import com.roombooking.service.RoomBookingServiceImpl;

import static com.roombooking.generator.RoomGenerator.generateManagedRooms;

/**
* Publisher for the WSDL
* @author Conor Smyth <cnrsmyth@gmail.com>
* @since 2016-04-18
*/
public class RoomBookingServicePublisher {
	public static void main(String[] args) {
		generateManagedRooms();

		System.out.println("Server started...");

		Endpoint.publish("http://127.0.0.1:9876/roomBooking", new RoomBookingServiceImpl());
	}
}
