package com.roombooking.generator;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Marshaller;

import com.roombooking.model.Room;
import com.roombooking.info.RoomInfo;
import static com.roombooking.info.Info.FILE_DIR;
import static com.roombooking.info.Info.MAX_DAYS;

public class RoomGenerator {
	private static JAXBContext jaxbContext;
	private static Marshaller jaxbMarshaller;

	public static void generateRooms() {
		Room[] rooms = RoomInfo.generateRooms();

		try {
			jaxbContext = JAXBContext.newInstance(Room.class);
		} catch(JAXBException e) {
			System.out.println("Error instantiating");
			e.printStackTrace();
		}

		try {
			jaxbMarshaller = jaxbContext.createMarshaller();
		} catch(JAXBException e) {
			System.out.println("Error creating marshaller");
			e.printStackTrace();
		}
		try {

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		} catch(PropertyException e) {
			System.out.println("Error setting marshaller property");
			e.printStackTrace();
		}

		System.out.println("Initialising data...");

		for(int dayNumber = 1; dayNumber <= MAX_DAYS; dayNumber++) {
			String fileName = FILE_DIR + dayNumber + ".xml";

			File file = new File(fileName);

			for(int roomIndex = 0; roomIndex < rooms.length; roomIndex++) {
				try {
					jaxbMarshaller.marshal(rooms[roomIndex], file);
				} catch(JAXBException e) {
					System.out.println("Error writing to file " + file);
					e.printStackTrace();
				}
			}
		}

		System.out.println("Finished writing data");
	}
}
