package com.roombooking.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessorType;

import java.io.Serializable;

@XmlRootElement
public class Rooms implements Serializable {
	private static final long serialVersionUID = 42L;

	private Room[] rooms;

	public Rooms() {}

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

		builder.append("Rooms [");

		for(Room room : rooms) {
			builder.append(room);
		}

		builder.append("]");

		return builder.toString();
	}
}
