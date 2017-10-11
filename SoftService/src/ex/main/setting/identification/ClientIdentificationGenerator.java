package ex.main.setting.identification;

import java.util.Random;

public class ClientIdentificationGenerator {
	private static final int charactersSize = 100;
	private static char[] characters = new char[charactersSize];
	private static int charactersCount = 0;
	private int passwordSize;

	public ClientIdentificationGenerator(int passwordSize) {
		this.passwordSize = passwordSize;
		initCharacters();
	}

	private static char[] initCharacters() {
		int i = 0;

		// 0-9
		for (int j = 48; j < 58; ++i, ++j, ++charactersCount) {
			characters[i] = (char) j;
		}

		//  a-z
		for (int j = 65; j < 91; ++i, ++j, ++charactersCount) {
			characters[i] = (char) j;
		}

		//  A-Z
		for (int j = 97; j < 123; ++i, ++j, ++charactersCount) {
			characters[i] = (char) j;
		}

		return characters;
	}

	public char[] get() {
		Random rnd = new Random();
		char[] password = new char[passwordSize];
		for (int i = 0; i < passwordSize; ++i) {
			password[i] = characters[rnd.nextInt(charactersCount)];
		}
		return password;
	}

	public void showCharacters() {
		for (int i = 0; i < charactersCount && characters[i] != 0; ++i) {
			System.out.println(characters[i]);
		}
	}
}
