package com.roombooking.service;

import javax.jws.WebService;

import java.util.LinkedList;

import com.roombooking.model.Room;
import com.roombooking.info.RoomInfo;

@WebService(endpointInterface = "com.roombooking.service.RoomBookingService")
public class RoomBookingServiceImpl implements RoomBookingService {

	public Room[] getRooms() {
		Room[] rooms = RoomInfo.generateRooms();

		return rooms;
	}
}
