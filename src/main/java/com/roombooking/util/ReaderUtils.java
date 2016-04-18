package com.roombooking.util;

import java.io.File;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;

import com.roombooking.model.Day;
import com.roombooking.model.Room;

public class ReaderUtils {
	private static JAXBContext jaxbContext;
	private static Marshaller jaxbMarshaller;

	public static Day readDay(Integer dayNumber) {
		String fileName = FILE_DIR + dayNumber + ".xml";

		readInit(new Class<Day>());

		File file = new File(fileName);
		
		try {
			return (Day) jaxbMarshaller.unmarshal(file);
		} catch(JAXBException e) {
			System.out.println("Error reading from file " + file);
			e.printStackTrace();
		}
	}

	private static void readInit(Class<?> clazz) {
		try {
			jaxbContext = JAXBContext.newInstance(clazz);
		} catch(JAXBException e) {
			System.out.println("Error instantiating");
			e.printStackTrace();
		}

		try {
			jaxbMarshaller = jaxbContext.createUnmarshaller();
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
