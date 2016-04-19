package com.roombooking.service;

import javax.jws.WebService;

import com.roombooking.model.Day;
import com.roombooking.model.Room;
import com.roombooking.model.Rooms;
import com.roombooking.info.RoomInfo;
import com.roombooking.util.JaxbMarshaller;

@WebService(endpointInterface = "com.roombooking.service.RoomBookingService")
public class RoomBookingServiceImpl implements RoomBookingService {
	
	/**
	* {@inheritDoc}
	*/
	public Rooms getManagedRooms() {
		JaxbMarshaller jaxbMarshaller = new JaxbMarshaller();

		Rooms rooms = jaxbMarshaller.getManagedRooms();

		return rooms;
	}

	/**
	 * {@inheritDoc}
	 */
	public Room getRoomForWeek(String roomName) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String isRoomAvailable(String roomName, String time, Integer day) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String bookRoom(String roomName, String time, Integer day) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String registerInterest(String roomName) {
		return null;
	}
}
