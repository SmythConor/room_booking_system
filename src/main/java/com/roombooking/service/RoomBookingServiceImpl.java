package com.roombooking.service;

import javax.jws.WebService;

import com.roombooking.model.Day;
import com.roombooking.model.Room;
import com.roombooking.model.Rooms;
import com.roombooking.model.Bookings;
import com.roombooking.info.RoomInfo;
import com.roombooking.util.JaxbMarshaller;
import com.roombooking.exception.RoomNotFoundException;

import static com.roombooking.info.RoomInfo.isRoom;
import static com.roombooking.info.RoomInfo.errorRoom;

@WebService(endpointInterface = "com.roombooking.service.RoomBookingService")
public class RoomBookingServiceImpl implements RoomBookingService {
	private Bookings bookings = new Bookings();
	
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
	public Bookings getRoomForWeek(String roomName) throws RoomNotFoundException {
		if(!isRoom(roomName)) {
			throw new RoomNotFoundException();
		}

		Bookings temp = bookings.getBookings();

		return temp;
	}

	/**
	 * {@inheritDoc}
	 */
	public String isRoomAvailable(String roomName, String time, Integer day) 
			throws RoomNotFoundException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String bookRoom(String roomName, String time, Integer day)
			throws RoomNotFoundException {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public String registerInterest(String roomName) throws RoomNotFoundException {
		return null;
	}
}
