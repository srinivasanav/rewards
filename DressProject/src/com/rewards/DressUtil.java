package com.rewards;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DressUtil {
	
	public static boolean allItemsWorn(List<Integer> validatedList, boolean isHot) {
		boolean allWorn = validatedList.contains(Actions.TAKE_OFF_PAJAMAS);
		allWorn = allWorn && validatedList.contains(Actions.PUT_ON_FOOTWEAR);
		allWorn = allWorn && validatedList.contains(Actions.PUT_ON_HEADWEAR);
		allWorn = allWorn && validatedList.contains(Actions.PUT_ON_SHIRT);
		allWorn = allWorn && validatedList.contains(Actions.PUT_ON_PANTS);
		allWorn = allWorn && validatedList.contains(Actions.PUT_ON_PANTS);
		if(isHot) return allWorn;
		allWorn = allWorn && validatedList.contains(Actions.PUT_ON_SOCKS);
		allWorn = allWorn && validatedList.contains(Actions.PUT_ON_JACKET);
		return allWorn;
	}
	
	public static String getNumbersString(String input) {
		String numbers = input.substring(input.indexOf(" "));
		numbers = numbers.trim();
		return numbers;
	}
	
	
	public static List<Integer> getList(String numbers) {
		List<Integer> list = new ArrayList<Integer>();
		StringTokenizer tokenizer = new StringTokenizer(numbers, ",");
		while(tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			token = token.trim();
			int intVal = Integer.parseInt(token);
			list.add(intVal);
		}	
		return list;
	}	
}
