package com.roombooking.model;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

/**
 * Class to represent all bookings
 * @author Conor Smyth <cnrsmyth@gmail.com>
 * @since 2016-04-19
 */
@XmlRootElement
public class Bookings implements Serializable {
	private static final long serialVersionUID = 42L;
	private final Integer MAX_BOOKINGS = 5 * 9 * 4;

	private Booking[] bookings;

	private Integer counter;

	public Bookings() {
		bookings = new Booking[MAX_BOOKINGS];

		this.counter = 0;
	}

	/**
	 * Add a booking 
	 * @param booking the booking to add
	 */
	public void addBooking(Booking booking) {
		bookings[counter] = booking;

		counter++;
	}

	public Bookings getBookings() {
		return this;
	}

	/**
	 * Get bookings for a room
	 * @param roomName the name of the room
	 * @return booking for room with name supplied
	 */
	public Bookings getBookingsForRoom(String roomName) {
		Bookings bookings = new Bookings();

		for(Booking booking : this.bookings) {
			if(booking != null && booking.getRoom().equals(roomName)) {
				bookings.addBooking(booking);
			}
		}

		return bookings;
	}

	/**
	 * Check does the booking exist
	 * @param booking the booking to check
	 * @return true if the booking already exists
	 */
	public boolean isBooked(Booking booking) {
		for(Booking b : bookings) {
			if(b != null && booking.equals(b)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("Bookings \n[\n");

		for(Booking booking : bookings) {
			if(booking != null) {
				builder.append("\t");
				builder.append(booking);
				builder.append("\n");
			}
		}

		builder.append("]");

		return builder.toString();
	}
}
