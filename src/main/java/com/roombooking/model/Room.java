package com.roombooking.model;

import javax.xml.bind.annotation.XmlElement;

import java.io.Serializable;

public class Room implements Serializable {
	private static final long serialVersionUID = 42L;

	private String name;
	private Integer capacity;

	public Room() {}

	public Room(String name, Integer capacity) {
		this.name = name;
		this.capacity = capacity;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getCapacity() {
		return capacity;
	}

	@Override
	public String toString() {
		return "Room = [name = " + name + ", capacity = " + capacity + "]";
	}
}
