package com.javacuckoo.protobuf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Int32Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.javacuckoo.models.Person;
import com.javacuckoo.protobuf.json.JPerson;

public class PerformanceTest {

	public static void main(String[] args) {

		// json serialisation
		JPerson person = new JPerson();
		person.setAge(10);
		person.setName("sam");
		ObjectMapper mapper = new ObjectMapper();
		Runnable json = () -> {
			try {
				byte[] personBytes = mapper.writeValueAsBytes(person);
				System.out.println(personBytes.length);
				JPerson newPerson = mapper.readValue(personBytes, JPerson.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		};

		// protobuf serializaion
		Person sam = Person.newBuilder().setName("sam").setAge(Int32Value.newBuilder().setValue(10).build()).build();
		
		Runnable proto = () -> {
			try {
				byte[] byteArray = sam.toByteArray();
				System.out.println(byteArray.length);
				Person newSam = Person.parseFrom(byteArray);
			} catch (InvalidProtocolBufferException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}; 

		for (int i = 0; i < 1; i++) {
			runPerformanceTest(json, "   JSON");
			runPerformanceTest(proto, "PROTO");
		}
		

	}

	public static void runPerformanceTest(Runnable runnable, String method) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 1; i++) {
			runnable.run();
		}
		long endTime = System.currentTimeMillis();
		System.out.println( method+" ==> "+ (endTime - startTime) + " ms");

	}

}
