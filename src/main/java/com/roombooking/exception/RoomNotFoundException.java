package com.roombooking.exception;

import java.io.Serializable;

public class RoomNotFoundException extends Exception implements Serializable {
	private static final long serialVersionUID = 6987393457309116469L;

	public RoomNotFoundException(String message) {
		super("Room not found");
	}
}
