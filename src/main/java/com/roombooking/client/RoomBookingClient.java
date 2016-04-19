package com.roombooking.client;

import java.net.URL;
import java.net.MalformedURLException;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import java.util.Scanner;

import com.roombooking.model.Room;
import com.roombooking.model.Rooms;
import com.roombooking.model.Bookings;
import com.roombooking.exception.RoomNotFoundException;
import com.roombooking.service.RoomBookingService;

public class RoomBookingClient {
	private static URL url;

	public static void main(String[] args) {
		try {
			url = new URL("http://127.0.0.1:9876/roomBooking?wsdl");
		} catch(MalformedURLException e) {
			e.printStackTrace();
		}

		QName qname = new QName("http://service.roombooking.com/", "RoomBookingServiceImplService");

		Service service = Service.create(url, qname);

		RoomBookingService roomBookingService = service.getPort(RoomBookingService.class);

		Scanner scanner = new Scanner(System.in);

		while(true) {
			System.out.println("Please select and option: ");
			System.out.println("1) Get managed Rooms");
			System.out.println("2) Get timetable for room");
			System.out.println("3) Check room availability");
			System.out.println("4) Make a booking");

			int choice = scanner.nextInt();
			printSeparator();

			if(choice == 1) {
				System.out.println("Getting managed rooms: ");

				Rooms rooms = roomBookingService.getManagedRooms();

				System.out.println(rooms);
			} else if(choice == 2) {
				System.out.print("Enter room name: ");

				scanner.nextLine();
				
				String roomName = scanner.nextLine();

				System.out.println("Getting room timetable for week: ");

				Object roomForWeek = roomBookingService.getRoomForWeek(roomName);

				System.out.println(roomForWeek);
			} else if(choice == 3) {
				scanner.nextLine();

				System.out.print("Enter room name: ");
				String roomName = scanner.nextLine();

				System.out.print("Enter time(09:00-22:00): ");
				String time = scanner.nextLine();

				System.out.print("Enter day(1-5): ");
				Integer day = scanner.nextInt();

				System.out.println(roomName + " " + time + " " + day);

				String response = roomBookingService.isRoomAvailable(roomName, time, day);

				System.out.println("\n" + response + "\n");
			} else if(choice == 4) {
				scanner.nextLine();

				System.out.print("Enter room name: ");
				String roomName = scanner.nextLine();

				System.out.print("Enter time(09:00-22:00): ");
				String time = scanner.nextLine();

				System.out.print("Enter day(1-5): ");
				Integer day = scanner.nextInt();

				String response = roomBookingService.bookRoom(roomName, time, day);

				System.out.println("\n" + response + "\n");
			}

			printSeparator();
		}
	}

	
	private static void printSeparator() {
		System.out.print("\n********************************************\n");
	}
}
