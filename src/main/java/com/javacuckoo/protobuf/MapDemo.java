package com.javacuckoo.protobuf;

import com.javacuckoo.models.BodyStyle;
import com.javacuckoo.models.Car;
import com.javacuckoo.models.Dealer;

public class MapDemo {

	
	public static void main(String[] args) {
		
		Car accord = Car.newBuilder().setMake("Honda").setModel("Accord").setYear(2020).setBodyStyle(BodyStyle.SEDAN).build();
		Car civic = Car.newBuilder().setMake("Honda").setModel("Civic").setYear(2005).build();
		
		Dealer dealer = Dealer.newBuilder().putModel(2020, accord).putModel(2005, civic).build();
		
//		System.out.println(dealer.toString());
		
		System.out.println(dealer.getModelOrThrow(2005).getBodyStyle());
		System.out.println("---------------------------------");
		System.out.println(dealer.getModelOrThrow(2020).getBodyStyle());

		

	}
	
}
