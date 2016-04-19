package com.roombooking.util;

public class Validation {
	public static boolean validTime(String time) {
		String[] times = time.split(":");

		Integer hour = Integer.parseInt(times[0]);
		Integer minutes = Integer.parseInt(times[1]);

		return hour >= 9 && hour <= 22 && minutes >= 0;
	}

	public static boolean validDay(Integer day) {
		return day > 0 && day <= 5;
	}
}
