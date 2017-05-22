package com.rewards;

import java.util.ArrayList;
import java.util.List;

public class GettingDressed {

	private boolean isHot = false;
	private boolean isCold = false;
	private String input;
	private ArrayList<String> listMessages = new ArrayList<String>();

	public boolean isHot() {
		return isHot;
	}

	public boolean isCold() {
		return isCold;
	}

	public String getInput() {
		return input;
	}

	public ArrayList<String> getListMessages() {
		return listMessages;
	}

	public GettingDressed(String input) {
		this.input = input.trim().toUpperCase();
		if (input.startsWith(Actions.HOT)) {
			this.isHot = true;
		} else if (input.startsWith(Actions.COLD)) {
			this.isCold = true;
		} else {
			listMessages.add("You have to start your input with either HOT or COLD");
		}
	}

	public String runValidations(List<Integer> list) {
		List<Integer> validatedList = new ArrayList<Integer>();

		String output = "";
		String failureMessage = "fail";
		;

		for (int count = 0; count < list.size(); count++) {

			int intVal = list.get(count);

			if ((intVal > Actions.MAX_LIMIT) || (intVal < Actions.MIN_LIMIT)) {
				listMessages.add("contains invalid number. Input numbers should be between 1 to 8");
				output = "contains invalid number. Input numbers should be between 1 to 8";
				return output;
			}

			if (count == 0) {
				if (intVal == Actions.TAKE_OFF_PAJAMAS) {
					output = output + "Removing PJs, ";

				} else {
					listMessages.add("Pajamas must be taken off before anything else can be put on");
					output = failureMessage;
					return output;
				}
			}
			if (validatedList.contains(intVal)) {
				listMessages.add("Only 1 piece of each type of clothing may be put on");
				output = output + failureMessage;
				return output;
			}
			if (intVal == Actions.PUT_ON_SOCKS) {
				if (isHot) {
					listMessages.add("You cannot put on socks when it is hot");
					output = output + failureMessage;
					return output;
				} else if (validatedList.contains(1)) {
					listMessages.add("Socks must be put on before footwear");
					output = output + failureMessage;
					return output;
				} else {
					output = output + "socks, ";
				}
			}

			if (intVal == Actions.PUT_ON_PANTS) {
				if (validatedList.contains(Actions.PUT_ON_FOOTWEAR)) {
					listMessages.add("Pants must be put on before footwear");
					output = output + failureMessage;
					return output;
				} else if (isHot) {
					output = output + "shorts, ";
				} else if (isCold) {
					output = output + "pants, ";
				}
			}
			if (intVal == Actions.PUT_ON_SHIRT) {
				if (validatedList.contains(Actions.PUT_ON_HEADWEAR) || validatedList.contains(Actions.PUT_ON_JACKET)) {
					listMessages.add("The shirt must be put on before the headwear or jacket");
					output = output + failureMessage;
					return output;
				} else {
					output = output + "shirt, ";
				}
			}

			if (intVal == Actions.PUT_ON_FOOTWEAR) {
				if (isHot) {
					output = output + "sandals, ";
				} else if (isCold) {
					output = output + "boots, ";
				}
			}

			if (intVal == Actions.PUT_ON_HEADWEAR) {
				if (isHot) {
					output = output + "sunglasses, ";
				} else if (isCold) {
					output = output + "hat, ";
				}
			}

			if (intVal == Actions.PUT_ON_JACKET) {
				if (isHot) {
					listMessages.add("You cannot put on jacket when it is hot");
					output = output + failureMessage;
					return output;
				} else {
					output = output + "jacket, ";
				}
			}

			if (intVal == Actions.LEAVE_HOUSE) {
				if (DressUtil.allItemsWorn(validatedList, isHot)) {
					output = output + "leaving house";
				} else {
					listMessages.add("You cannot leave the house until all items of clothing are on");
					output = output + failureMessage;
					return output;
				}
			}

			validatedList.add(intVal);
		}
		return output;
	}

}