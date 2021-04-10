package com.javacuckoo.protobuf;

import java.util.Arrays;

import com.google.protobuf.Int32Value;
import com.javacuckoo.models.Address;
import com.javacuckoo.models.Car;
import com.javacuckoo.models.Person;

public class CompositionDemo {

	
	public static void main(String[] args) {
		Address address = Address.newBuilder().setPostbox(123).setStreet("main street").setCity("Atlanta").build();
		
		Car accord = Car.newBuilder().setMake("Honda").setModel("Accord").setYear(2020).build();
		Car civic = Car.newBuilder().setMake("Honda").setModel("Civic").setYear(2005).build();
		
		Person sam = Person.newBuilder().setName("sam").setAge(Int32Value.newBuilder().setValue(10).build()).setAddress(address).addCar(accord).addCar(civic).build();
		
		System.out.print(sam.toString());
		System.out.print(sam.hasAge());

		System.out.print("---------------------------");

		Person sam2 = Person.newBuilder().setName("sam2").setAge(Int32Value.newBuilder().setValue(10).build()).setAddress(address).addAllCar(Arrays.asList(civic, accord)).build();

		System.out.print(sam2.toString());

	}
	
}
