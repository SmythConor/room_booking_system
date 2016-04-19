package com.roombooking.model;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement
public class Bookings implements Serializable {
	private static final long serialVersionUID = 42L;
	private final Integer MAX_BOOKINGS = 5 * 9 * 4;

	private Booking[] bookings;

	private Integer counter;

	public Bookings() {
		bookings = new Booking[MAX_BOOKINGS];

		this.counter = 0;

		Booking booking = new Booking();

		booking.setRoom("XG14");
		booking.setTime("12:00");
		booking.setDay(1);

		addBooking(booking);
	}

	public void addBooking(Booking booking) {
		bookings[counter] = booking;

		counter++;
	}

	public Bookings getBookings() {
		return this;
	}

	public Bookings getBookingsForRoom(String roomName) {
		Bookings bookings = new Bookings();

		for(Booking booking : this.bookings) {
			if(booking.getRoom().equals(roomName)) {
				bookings.addBooking(booking);
			}
		}

		return bookings;
	}

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
