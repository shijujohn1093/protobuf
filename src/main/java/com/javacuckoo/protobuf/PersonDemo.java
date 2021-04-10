package com.javacuckoo.protobuf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.protobuf.Int32Value;
import com.javacuckoo.models.Person;

public class PersonDemo {

	public static void main(String[] args) throws IOException {
		Person sam = Person.newBuilder().setName("sam1").setAge(Int32Value.newBuilder().setValue(10).build()).build();

		Path path = Paths.get("sam.ser");

		Files.write(path, sam.toByteArray());

		System.out.println("Written");

		byte[] readAllBytes = Files.readAllBytes(path);
		Person newPerson = Person.parseFrom(readAllBytes);
		System.out.println(newPerson.toString());

	}

}
