package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	
	static int fullAlphabet = 26;
	public static void main(String[] args) {
		String s = "";
		String r = "";
		s = readline();
r = FD_Helper.decrypt(s);
JOptionPane.showMessageDialog(null, r);
	}
	

	
	public static String readline() {
		String l2 = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"src/_02_File_Encrypt_Decrypt/Encrypt.txt"));
			
			String line = br.readLine();
		
			while(line != null) {
				l2 += line;
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l2;
	}
	

}

//Copyright © 2019 Dylan Van Winkle