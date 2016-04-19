package com.roombooking.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import static javax.jws.soap.SOAPBinding.Style.RPC;

import java.util.LinkedList;

import com.roombooking.model.Room;
import com.roombooking.model.Rooms;
import com.roombooking.model.Bookings;
import com.roombooking.exception.RoomNotFoundException;

/**
 * Service interface to define endpoints
 * @author Conor Smyth <cnrsmyth@gmail.com>
 * @since 2016-04-18
 */
@WebService
@SOAPBinding(style = RPC)
public interface RoomBookingService {

	/**
	 * Get the managed rooms for this service
	 * @return Rooms array of rooms managed by this service
	 */
	@WebMethod Rooms getManagedRooms();

	/**
	 * Get a rooms schedule for a week
	 * @param roomName The name of the room
	 * @return Not sure yet
	 */
	@WebMethod Object getRoomForWeek(String roomName);

	/**
	 * Check is a room available for a certain time and day
	 * @param roomName the name of the room
	 * @param time the time to check
	 * @param day the day number
	 * @return indication of room availability
	 */
	@WebMethod String isRoomAvailable(String roomName, String time, Integer day);

	/**
	 * Book a room
	 * @param roomName The name of the room
	 * @param time the time to book
	 * @param day the day to book
	 * @return ack of request or notification that room is booked
	 */
	@WebMethod String bookRoom(String roomName, String time, Integer day);

	/**
	 * Register interest in a room in case the room is made available
	 * @param roomName the name of the room
	 * @return confirmation of registration 
	 */
	@WebMethod String registerInterest(String roomName) throws RoomNotFoundException;
}
