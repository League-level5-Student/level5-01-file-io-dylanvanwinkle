package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

;

public class DirectoryIteratorWork {
	public static void main(String[] args) {
		select();
	}

	public static void select() {
		FileWriter fw;
		File d = new File("src");
		File[] files = d.listFiles();
		if (files != null) {
			for (File f : files) {
				System.out.println(f.getAbsolutePath());
				File[] files2 = f.listFiles();
				for (File f2 : files2) {
					if (f2.getAbsolutePath().contains(".java")) {
						try {
							
								fw = new FileWriter(f2, true);	
							
							

							fw.write("\n//Copyright © 2019 Dylan Van Winkle");

							fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}

	}
}

//Copyright © 2019 Dylan Van Winkle