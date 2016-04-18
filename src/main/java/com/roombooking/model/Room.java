package com.roombooking.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessorType;
import static javax.xml.bind.annotation.XmlAccessType.FIELD;

import java.io.Serializable;

@XmlRootElement
//@XmlAccessorType(FIELD)
public class Room implements Serializable {
	private static final long serialVersionUID = 42L;

	//@XmlElement(name = "name", required = true)
	private String name;
	//@XmlElement(name = "capacity", required = true)
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

	public String toString() {
		return "Room = [ name = " + name + ", capacity = " + capacity + "]";
	}
}
