package ex.main.setting.identification;

import java.util.Random;

public class ClientIdentificationGenerator {
	private static String charList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public ClientIdentificationGenerator() {
		
	}

	private static int getRandom() {
		int randomInt = 0;
		Random randomGenerator = new Random();
		randomInt = randomGenerator.nextInt(charList.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}

	public static String random() {
		int stringLength = 7;
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < stringLength; i++) {
			int num = getRandom();
			char ch = charList.charAt(num);
			str.append(ch);
		}
		return str.toString();
	}

}
