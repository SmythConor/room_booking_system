package com.roombooking.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

/**
 * class to represent an array of rooms
 * @author Conor Smyth <cnrsmyth@gmail.com>
 * @since 2016-04-19
 */
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		builder.append("Rooms \n[\n");

		for(Room room : rooms) {
			builder.append("\t");
			builder.append(room);
			builder.append("\n");
		}

		builder.append("]");

		return builder.toString();
	}
}
