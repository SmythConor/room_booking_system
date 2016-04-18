package com.roombooking.info;

import java.util.List;
import java.util.LinkedList;

import com.roombooking.model.Room;

public class RoomInfo {
	public static Room[] generateRooms() {
		Room r1 = new Room("L221", 50);
		Room r2 = new Room("XG14", 34);
		Room r3 = new Room("T101", 400);
		Room r4 = new Room("CG04", 40);

		return new Room[]{r1, r2, r3, r4};
	}
}
