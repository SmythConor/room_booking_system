package com.roombooking.generator;

import java.io.File;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;

import com.roombooking.model.Day;
import com.roombooking.model.Room;
import static com.roombooking.info.Info.FILE_DIR;
import static com.roombooking.info.Info.MAX_DAYS;

public class RoomGenerator {
	private static JAXBContext jaxbContext;
	private static Marshaller jaxbMarshaller;

	public static void generateRooms() {
		try {
			jaxbContext = JAXBContext.newInstance(Day.class);
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

		Room[] rooms = generateDefaultRooms();


		for(int dayNumber = 1; dayNumber <= MAX_DAYS; dayNumber++) {
		String fileName = FILE_DIR + dayNumber + ".xml";
		File file = new File(fileName);
			Day day = new Day();

			day.setDay(dayNumber);
			day.setRooms(rooms);
			try {
				jaxbMarshaller.marshal(day, file);
			} catch(JAXBException e) {
				System.out.println("Error writing to file " + file);
				e.printStackTrace();
			}
		}

		System.out.println("Finished writing data");
	}

	public static Room[] generateDefaultRooms() {
		Room r1 = new Room("L221", 50);
		Room r2 = new Room("XG14", 34);
		Room r3 = new Room("T101", 400);
		Room r4 = new Room("CG04", 40);

		return new Room[] {r1, r2, r3, r4};
	}
}
