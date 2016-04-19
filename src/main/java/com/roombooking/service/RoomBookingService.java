package com.roombooking.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import static javax.jws.soap.SOAPBinding.Style.RPC;

import java.util.LinkedList;

import com.roombooking.model.Day;
import com.roombooking.model.Room;

@WebService
@SOAPBinding(style = RPC)
public interface RoomBookingService {
	@WebMethod Room[] getManagedRooms();
	@WebMethod Day[] getRoomForWeek(String roomName);
}
