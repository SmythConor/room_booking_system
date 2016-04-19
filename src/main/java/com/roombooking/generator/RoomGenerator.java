package com.roombooking.generator;

import javax.xml.bind.Marshaller;

import com.roombooking.model.Room;
import com.roombooking.model.Rooms;
import com.roombooking.util.JaxbMarshaller;
import static com.roombooking.info.Info.FILE_DIR;
import static com.roombooking.info.Info.MAX_DAYS;
import static com.roombooking.info.Info.ROOMS_FILE;

public class RoomGenerator {
	public static void generateManagedRooms() {
		JaxbMarshaller jaxbMarshaller = new JaxbMarshaller(Marshaller.class, Rooms.class);

		System.out.println("Initialising data...");

		Room[] temp = generateDefaultRooms();

		Rooms rooms = new Rooms();

		rooms.setRooms(temp);

		jaxbMarshaller.write(rooms, ROOMS_FILE);

		System.out.println("Finished writing data");
	}

	private static Room[] generateDefaultRooms() {
		Room r1 = new Room("L221", 50);
		Room r2 = new Room("XG14", 34);
		Room r3 = new Room("T101", 400);
		Room r4 = new Room("CG04", 40);

		return new Room[] {r1, r2, r3, r4};
	}
}
