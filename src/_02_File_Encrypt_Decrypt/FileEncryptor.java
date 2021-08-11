package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	static /*
			 * Encryption is the process of encoding a message or information in such a way
			 * that only authorized parties can access it and those who are not authorized
			 * cannot.
			 *
			 * A simple shift cipher works by shifting the letters of a message down based
			 * on a key. If our key is 4 then:
			 * 
			 * a b c d e f g h i j k l m n o p q r s t u v w x y z
			 * 
			 * becomes:
			 *
			 * e f g h i j k l m n o p q r s t u v w x y z a b c d
			 * 
			 * "Hello World" changes to "Lipps Asvph"
			 *
			 * Create a program that takes a message and a key from the user. Use the key to
			 * shift each letter in the users input and save the final result to a file.
			 */
	int fullAlphabet = 26;

	public static void main(String[] args) {
		String code = "";
		String file = "";
		String s1 = JOptionPane.showInputDialog("Enter a message(Without Special Characters).");
		String s2 = JOptionPane.showInputDialog("Enter a number(That is not negitive).");
		int upZ = 90;
		int lowZ = 122;
		int lowA = 97;
		int space = 32;
		
		int i1 = Integer.parseInt(s2);
		if (i1 < 0) {
			System.out.println("Error");
			System.exit(0);
		}
		i1 = sub(i1);
		for (int i = 0; i < s1.length(); i++) {
			code += s1.charAt(((int) i)) + i1;
			code += "!";
		}
		String[] s = code.split("!");

		for (int i = 0; i < s.length; i++) {
			int in = Integer.parseInt(s[i]);
			
			if (in == space + i1) {
				in = space;
		
			}
			if (in > upZ && in < lowA && in != space) {
				in -= fullAlphabet;
			}
			if (in > lowZ && in != space) {
				in -= fullAlphabet;
			}

			file += (char) in;
		}

		try {
			FileWriter fw = new FileWriter(
					"C:\\Users\\dylan\\git\\level5-01-file-io-dylanvanwinkle\\src\\_02_File_Encrypt_Decrypt\\Encrypt.txt");

			fw.write(file);

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static int sub(int i) {
		while (i > fullAlphabet) {
			i -= fullAlphabet;
			if (i < fullAlphabet) {
				return i;
			}
		}
		if (i <= fullAlphabet) {
			return i;
		}
		return -1;
	}
}

//Copyright © 2019 Dylan Van Winkle