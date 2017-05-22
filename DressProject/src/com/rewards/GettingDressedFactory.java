package com.rewards;

public class GettingDressedFactory {
	
	public static GettingDressed getInstance(String input) {
		
		GettingDressed object = new GettingDressed(input);
		return object;
	}
}
