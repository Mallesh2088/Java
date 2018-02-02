package com.learning.java8;

import java.util.Optional;

import com.learning.java8.dto.Address;
import com.learning.java8.dto.Person;

public class OptionalExample {

	public static void main(String[] args) {

        Person person = new Person();
        person.setName("Test");
        Address address = new Address();
        address.setCityName("Dublin");
        person.setAddress(Optional.of(address));
        person.getAddress().ifPresent(OptionalExample::processAddress);
    }

	private static void processAddress(Address theAddress) {
		System.out.println(theAddress);
	}

}
