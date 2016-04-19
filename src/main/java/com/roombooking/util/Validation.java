package com.roombooking.util;

/**
 * Validation class for validating input
 * @author Conor Smyth <cnrsmyth@gmail.com>
 * @since 2016-04-19
 */
public class Validation {
	/**
	 * Validate the time format
	 * @param time the time to validate
	 * @return true if time is on the hour and during working hours
	 */
	public static boolean validTime(String time) {
		String[] times = time.split(":");

		Integer hour = Integer.parseInt(times[0]);
		Integer minutes = Integer.parseInt(times[1]);

		return hour >= 9 && hour <= 22 && minutes >= 0;
	}

	/**
	 * Validate the day
	 * @param day the day to validate
	 * @return true if the day is bewteen 1 and 5
	 */
	public static boolean validDay(Integer day) {
		return day > 0 && day <= 5;
	}
}
