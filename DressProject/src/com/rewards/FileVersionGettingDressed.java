package com.rewards;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileVersionGettingDressed  extends DressBase {

	public static void main(String[] args) throws Exception {

		String fileName = ".\\src\\com\\rewards\\InputLines.txt";
		BufferedReader br = new BufferedReader(new FileReader(fileName));

		String input = null;
		while ((input = br.readLine()) != null) {
			String output = new FileVersionGettingDressed().getDressed(input);
			System.out.println("\nInput  : " + input);
			System.out.println("Output : " + output);
		}
		br.close();
	}
}
