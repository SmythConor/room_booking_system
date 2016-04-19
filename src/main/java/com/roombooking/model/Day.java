package com.roombooking.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@XmlRootElement
public class Day implements Serializable {
	private static final long serialVersionUID = 42L;

	private Integer day;
	private Room[] rooms;

	public Day() {}

	@XmlElement
	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getDay() {
		return day;
	}

	@XmlElement
	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}

	public Room[] getRooms() {
		return rooms;
	}

	public Room getRoom(String name) {
		for(Room room : rooms) {
			if(room.getName().equals(name)) {
				return room;
			}
		}

		return null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("Day [day = ");
		builder.append(day);
		builder.append(" Rooms [");
		for(Room room : rooms) {
			builder.append(room);
		}
		builder.append("]]");

		return builder.toString();
	}
}
