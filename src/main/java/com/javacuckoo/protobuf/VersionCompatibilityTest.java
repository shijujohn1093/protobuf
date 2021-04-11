package com.javacuckoo.protobuf;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.javacuckoo.models.Television;


public class VersionCompatibilityTest {

	public static void main(String[] args) throws IOException {
		
// Reading from version 1		
//		Television television = Television.newBuilder().setBrand("sony").setYear(2015).build();
//		
//		Path path = Paths.get("tv.v1");
//		Files.write(path, television.toByteArray());
		
//		byte[] bytes = Files.readAllBytes(path);
//		
//		System.out.println(Television.parseFrom(bytes));
		
		//------------------ Reading using new version file
		
		
		Path pathV1 = Paths.get("tv.v1");
		Path pathV2 = Paths.get("tv.v2");
//		Television television = Television.newBuilder().setBrand("sony").setModel(2016).setType(Type.OLED).build();
//		Files.write(pathV2, television.toByteArray());
		
		Path path = Paths.get("tv.v1");
		
		byte[] bytes = Files.readAllBytes(path);
		System.out.println(Television.parseFrom(bytes));
		
		


	}
}
