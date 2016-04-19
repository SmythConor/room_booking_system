package com.roombooking.info;

import com.roombooking.model.Room;
import static com.roombooking.generator.RoomGenerator.generateDefaultRooms;

/**
 * Class to hold room info
 * @author Conor Smyth <cnrsmyth@gmail.com>
 * @since 2016-04-18
 */
public class RoomInfo {
	/**
	 * Check if the room supplied is a room
	 * @param roomName the name of the room
	 * @return true if the room exists
	 */
	public static boolean isRoom(String roomName) {
		Room[] rooms = generateDefaultRooms();

		boolean exists = false;

		for(Room room : rooms) {
			if(room.getName().equals(roomName)) {
				exists = true;
			}
		}

		return exists;
	}
}
