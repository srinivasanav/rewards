package com.rewards;

import java.util.List;

public class DressBase {

	public String getDressed(String input) throws Exception {
		String output = "";
		GettingDressed object = GettingDressedFactory.getInstance(input);
		if (object.isHot() || object.isCold()) {
			String numbers = DressUtil.getNumbersString(object.getInput());
			List<Integer> list = DressUtil.getList(numbers);
			output = object.runValidations(list);
		} else {
			throwException(object.getListMessages());
		}
		return output;
	}

	public void throwException(List<String> listMessages) throws Exception {
		String exceptionMessage = "\nYour input should look like the following: \nExample 1 : HOT 8, 6, 4, 2, 1, 7"
				+ "\nExample 2 : COLD 8, 6, 3, 4, 2, 5, 1, 7" + "\nYour input failed with following messages = ";
		for (String message : listMessages) {
			exceptionMessage = exceptionMessage + "\n" + message;
		}

		throw new Exception(exceptionMessage);
	}
}
