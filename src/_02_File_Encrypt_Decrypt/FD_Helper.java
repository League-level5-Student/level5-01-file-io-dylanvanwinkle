package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
// undo go over alphebet again after number > 26.
public class FD_Helper {
	static int fullAlphabet = 26;
	public static String decrypt(String m) {
		String code = "";
		String file = "";
		String s1 = m;
		String s2 = JOptionPane.showInputDialog("Enter a number(That is not negitive).");
		int space = 32;
		
		int i1 = Integer.parseInt(s2);
		if (i1 < 0) {
			System.out.println("Error");
			System.exit(0);
		}
		i1 = sub(i1);
		for (int i = 0; i < s1.length(); i++) {
			code += s1.charAt(((int) i)) - i1;
			code += "!";
		}
		String[] s = code.split("!");

		for (int i = 0; i < s.length; i++) {
			int in = Integer.parseInt(s[i]);
			
			if (in == space - i1) {
				in = space;
		
			}
			if (in < 'A' && in != space) {
				int temp = 'A' - in;
				temp = temp - 1;
				in = 'Z' - temp;
			
			} if (in < 'a' && in != space && in > 'Z') {
				int temp = 'a' - in;
				temp = temp - 1;
				in = 'z' - temp;
			}

			file += (char) in;
		}

return file;
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
