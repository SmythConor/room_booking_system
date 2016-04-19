package com.roombooking.model;

import javax.xml.bind.annotation.XmlElement;

import java.io.Serializable;

public class Booking implements Serializable {
	private static final long serialVersionUID = 42L;

	private String roomName;
	private String time;
	private Integer day;

	private boolean isBooked;

	public Booking() {}

	@XmlElement
	public void setRoom(String roomName) {
		this.roomName = roomName;
	}

	public String getRoom() {
		return roomName;
	}

	@XmlElement
	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	@XmlElement
	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getDay() {
		return day;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("Booking [room = ");
		builder.append(roomName);
		builder.append(", time = ");
		builder.append(time);
		builder.append(", day = ");
		builder.append(day);
		builder.append("]");

		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		Booking booking = (Booking) obj;

		return this.roomName.equals(booking.getRoom())
					 && this.time.equals(booking.getTime())
					 && this.day == booking.getDay();
	}
}
