package com.roombooking.service;

import javax.jws.WebService;

import com.roombooking.model.Rooms;
import com.roombooking.model.Booking;
import com.roombooking.model.Bookings;
import com.roombooking.util.JaxbMarshaller;

import static com.roombooking.info.RoomInfo.isRoom;
import static com.roombooking.util.Validation.validTime;
import static com.roombooking.util.Validation.validDay;

/**
 * Room Service implementation
 * @author Conor Smyth <cnrsmyth@gmail.com>
 * @since 2016-04-19
 */
@WebService(endpointInterface = "com.roombooking.service.RoomBookingService")
public class RoomBookingServiceImpl implements RoomBookingService {
	private Bookings bookings = new Bookings();
	private Bookings pendingBookings = new Bookings();

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
	public Object getRoomForWeek(String roomName) {
		if(!isRoom(roomName)) {
			return "Room not found";
		}

		Bookings temp = bookings.getBookingsForRoom(roomName);

		return temp.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	public String isRoomAvailable(String roomName, String time, Integer day) {
		if(!isRoom(roomName)) {
			return "Room does not exist";
		}

		if(!validTime(time)) {
			return "Time invalid\nOpening hours 09:00 - 22:00\nPlease submit in this format";
		}

		if(!validDay(day)) {
			return "Day invalid\nDays 1-5";
		}

		Booking booking = new Booking();

		booking.setRoom(roomName);
		booking.setTime(time);
		booking.setDay(day);

		if(bookings.isBooked(booking)) {
			return "Room is booked for this day and time";
		} else {
			return "Room available";
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public String bookRoom(String roomName, String time, Integer day) {
		if(!isRoom(roomName)) {
			return "Room does not exist";
		}

		if(!validTime(time)) {
			return "Time invalid\nOpening hours 09:00 - 22:00\nPlease submit in this format";
		}

		if(!validDay(day)) {
			return "Day invalid\nDays 1-5";
		}

		Booking booking = new Booking();

		booking.setRoom(roomName);
		booking.setTime(time);
		booking.setDay(day);

		if(bookings.isBooked(booking)) {
			return "Room is booked for this time";
		}

		bookings.addBooking(booking);

		return "Room booked " + booking.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	public String registerInterest(String roomName, String time, Integer day) {
		Booking booking = new Booking();

		booking.setRoom(roomName);
		booking.setTime(time);
		booking.setDay(day);

		pendingBookings.addBooking(booking);

		return "Interest registered";
	}
}
