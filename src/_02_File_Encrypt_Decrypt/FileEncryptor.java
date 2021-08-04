package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
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
	public static void main(String[] args) {
		String code = "";
		String s1 = JOptionPane.showInputDialog("Enter a message.");
		String s2 = JOptionPane.showInputDialog("Enter a number(That is not negitive).");

		int i1 = Integer.parseInt(s2);
		if (i1 < 0) {
			System.out.println("Error");
			System.exit(0);
		}
		i1 = sub(i1);
		for (int i = 0; i < s1.length(); i++) {
			code += s1.charAt(((int) i)) + i1;
		}
		
		// NEED TO CONVERT ASCII NUMBER BACK INTO LETTERS BEFORE I ADD TO FILE.
		
		
		
		  try { FileWriter fw = new
		  FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt");
		  
		  
		  fw.write((String)code);
		  
		  fw.close(); } catch (IOException e) { e.printStackTrace(); }
		 
	}

	public static int sub(int i) {
		while (i > 26) {
			i -= 26;
			if (i < 26) {
				return i;
			}
		}
		if (i <= 26) {
			return i;
		}
		return -1;
	}
}
