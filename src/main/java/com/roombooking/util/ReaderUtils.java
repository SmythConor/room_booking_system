package com.roombooking.util;

import java.io.File;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;

import com.roombooking.model.Day;
import com.roombooking.model.Room;
import static com.roombooking.info.Info.FILE_DIR;
import static com.roombooking.info.Info.MAX_DAYS;

public class ReaderUtils {
	private static JAXBContext jaxbContext;
	private static Marshaller jaxbMarshaller;
	private static Unmarshaller jaxbUnmarshaller;

	public static Day readDay(Integer dayNumber) {
		String fileName = FILE_DIR + dayNumber + ".xml";

		readInit(Day.class);

		File file = new File(fileName);
		
		try {
			return (Day) jaxbUnmarshaller.unmarshal(file);
		} catch(JAXBException e) {
			System.out.println("Error reading from file " + file);
			e.printStackTrace();
		}

		return null;
	}

	public static Day[] getRoomForWeek(String roomName) {
		Day[] days = new Day[MAX_DAYS];

		for(int dayIndex = 1; dayIndex <= MAX_DAYS; dayIndex++) {
			Day day = readDay(dayIndex);

			Room room = day.getRoom(roomName);

			Day temp = new Day();

			temp.setDay(dayIndex);
			temp.setRooms(new Room[] {room});

			days[dayIndex - 1] = temp;
		}

		return days;
	}

	private static void readInit(Class<?> clazz) {
		try {
			jaxbContext = JAXBContext.newInstance(clazz);
		} catch(JAXBException e) {
			System.out.println("Error instantiating");
			e.printStackTrace();
		}

		try {
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		} catch(JAXBException e) {
			System.out.println("Error creating unmarshaller");
			e.printStackTrace();
		}
	}

	private static void writeInit(Class<?> clazz) {
		try {
			jaxbContext = JAXBContext.newInstance(clazz);
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
	}
}
