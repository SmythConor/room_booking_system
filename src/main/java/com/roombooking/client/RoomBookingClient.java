package com.roombooking.client;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import java.util.LinkedList;

import com.roombooking.model.Room;
import com.roombooking.service.RoomBookingService;

public class RoomBookingClient {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://127.0.0.1:9876/roomBooking?wsdl");

		QName qname = new QName("http://service.roombooking.com/", "RoomBookingServiceImplService");

		Service service = Service.create(url, qname);

		RoomBookingService roomBookingService = service.getPort(RoomBookingService.class);
		Room[] rooms = roomBookingService.getRooms();

		for(Room room : rooms) {
			System.out.println(room);
		}
	}
}
