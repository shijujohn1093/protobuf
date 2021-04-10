package com.javacuckoo.protobuf;

import com.javacuckoo.models.Credentials;
import com.javacuckoo.models.EmailCredentials;
import com.javacuckoo.models.PhoneOTP;

public class OneOfDemo {
	
	public static void main(String[] args) {
		EmailCredentials emailCredentials = EmailCredentials.newBuilder().setEmail("nobody@gmail.com").setPassword("password123").build();
		
		PhoneOTP phoneOTP = PhoneOTP.newBuilder().setNumber(1212121212).setCode(456).build();
		
		Credentials credentials = Credentials.newBuilder().setPhoneMode(phoneOTP).setEmailMode(emailCredentials).build();
		// -- it will enable only last mode earlier mode will be removed
		
		login(credentials);
	}
	
	private static void login(Credentials credentials) {
//		System.out.println(credentials.getEmailMode());
//		System.out.println(credentials.getPhoneMode()); // It will print only phone
		
		// ---------
		
		switch (credentials.getModeCase()) {
		case EMAILMODE:
			System.out.println(credentials.getEmailMode());
			break;
		case PHONEMODE :
			System.out.println(credentials.getPhoneMode());
			break;
		default:
			break;
		}

	}

}
