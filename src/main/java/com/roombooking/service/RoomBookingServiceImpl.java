package com.roombooking.service;

import javax.jws.WebService;

import java.util.LinkedList;

import com.roombooking.model.Day;
import com.roombooking.model.Room;
import com.roombooking.info.RoomInfo;
import com.roombooking.util.ReaderUtils;
import static com.roombooking.util.ReaderUtils.readDay;

import static com.roombooking.generator.RoomGenerator.generateDefaultRooms;

@WebService(endpointInterface = "com.roombooking.service.RoomBookingService")
public class RoomBookingServiceImpl implements RoomBookingService {

	public Room[] getManagedRooms() {
		Room[] rooms = generateDefaultRooms();

		return rooms;
	}

	public Day[] getRoomForWeek(String roomName) {
		return ReaderUtils.getRoomForWeek(roomName);
	}
}
