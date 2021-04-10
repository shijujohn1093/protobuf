package com.javacuckoo.protobuf;

import com.javacuckoo.models.Person;

public class DefaultValueDemo {

	public static void main(String[] args) {
		Person person = Person.newBuilder().build();
		
		
		System.out.println(person.getName());

		System.out.println(person.getAge());
		System.out.println("City : "+person.getAddress().getCity());
		System.out.println(person.hasAddress());
		System.out.println(person.getCarCount());
		System.out.println(person.getCarList().size());


	}
}
