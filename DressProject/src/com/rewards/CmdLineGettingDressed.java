package com.rewards;

import java.util.Scanner;

public class CmdLineGettingDressed extends DressBase {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {

			String input = sc.nextLine();
			String output = new CmdLineGettingDressed().getDressed(input);
			System.out.println("\nInput  : " + input);
			System.out.println("Output : " + output);
		}
		sc.close();
	}
}
