package com.learning.java8.dto;

import java.util.Optional;

public class Person {
	
	private String name;
	private Optional<Address> address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Optional<Address> getAddress() {
		return address;
	}
	public void setAddress(Optional<Address> address) {
		this.address = address;
	}
	
}
