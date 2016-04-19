package com.roombooking.info;

import java.util.List;
import java.util.LinkedList;

import com.roombooking.model.Room;

public class RoomInfo {
	public static boolean isRoom(String roomName) {
		Room[] rooms = generateRooms();

		boolean exists = false;

		for(Room room : rooms) {
			if(room.getName().equals(roomName)) {
				exists = true;
			}
		}

		return exists;
	}
	public static Room[] generateRooms() {
		Room r1 = new Room("L221", 50);
		Room r2 = new Room("XG14", 34);
		Room r3 = new Room("T101", 400);
		Room r4 = new Room("CG04", 40);

		return new Room[]{r1, r2, r3, r4};
	}

	public static Room errorRoom() {
		Room err = new Room();

		err.setName("Room not found");
		err.setCapacity(0);

		return err;
	}
}
