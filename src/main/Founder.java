package main;

import java.util.regex.Pattern;

public class Founder {
	private String name , phoneNumber;

	public Founder (String name , String phoneNumber) {
		this.name = name ;
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public static boolean isPhoneNumberCorrect (String phoneNumber) {
		String phoneNumberFormat = "^0(7|6|5)[0-9]{8,8}$";
		return Pattern.matches(phoneNumberFormat, phoneNumber) ;
	}
}
