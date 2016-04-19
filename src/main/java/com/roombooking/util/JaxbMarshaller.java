package com.roombooking.util;

import java.io.File;

import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBException;
import javax.xml.bind.PropertyException;

import com.roombooking.model.Rooms;
import static com.roombooking.info.Info.ROOMS_FILE;

/**
 * Wrapper class for writing xml files
 * @author Conor Smyth <cnrsmyth@gmail.com>
 * @since 2016-04-19
 */
public class JaxbMarshaller {
	private JAXBContext jaxbContext;
	private Marshaller jaxbMarshaller;
	private Unmarshaller jaxbUnmarshaller;

	public JaxbMarshaller() {}

	/**
	 * All args constructor
	 * @param marshallerType the type of marshaller
	 * @param clazz the class to write
	 */
	public JaxbMarshaller(Class<?> marshallerType, Class<?> clazz) {
		init(clazz);

		if(marshallerType.toString().contains("Unmarshaller")) {
			createUnMarshaller();
		} else if(marshallerType.toString().contains("Marshaller")) {
			createMarshaller();
		} else {
			System.out.println("Incorrect type passed to JaxbMarshaller: " + marshallerType);
			System.exit(1);
		}
	}

	/**
	 * Read the managed rooms
	 * @return the rooms managed by this service
	 */
	public Rooms getManagedRooms() {
		init(Rooms.class);
		createUnMarshaller();

		File file = new File(ROOMS_FILE);

		try {
			return (Rooms) jaxbUnmarshaller.unmarshal(file);
		} catch(JAXBException e) {
			System.out.println("Error reading rooms" + file);
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Write object to file
	 * @param o the object to write
	 * @param fileName the name of the file to write
	 */
	public void write(Object o, String fileName) {
		File file = new File(fileName);

		try {
			jaxbMarshaller.marshal(o, file);
		} catch(JAXBException e) {
			System.out.println("Error writing to " + file);
		}
	}

	/**
	 * Write object array to file
	 * @param o the object array to write
	 * @param fileName the name of the file to write
	 */
	public void write(Object[] o, String fileName) {
		File file = new File(fileName);

		if(o == null) {
			System.out.println();

		}
		try {
			jaxbMarshaller.marshal(o, file);
		} catch(JAXBException e) {
			System.out.println("Error writing to " + file);
			e.printStackTrace();
		}
	}

	/**
	 * Initialise the jaxb context
	 */
	private void init(Class<?> clazz) {
		try {
			jaxbContext = JAXBContext.newInstance(clazz);
		} catch(JAXBException e) {
			System.out.println("Error instantiating");
			e.printStackTrace();
		}
	}

	/**
	 * Create an unmarshaller
	 */
	private void createUnMarshaller() {
		try {
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		} catch(JAXBException e) {
			System.out.println("Error creating unmarshaller");
			e.printStackTrace();
		}
	}

	/**
	 * Create a marshaller
	 */
	private void createMarshaller() {
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
