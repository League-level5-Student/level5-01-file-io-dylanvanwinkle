package Checkpoint;

import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import _02_Pixel_Art.GridPanel;
import _02_Pixel_Art.PixelArtMaker;

public class TextEditor implements Serializable{
static JFrame f = new JFrame();
static JPanel p = new JPanel();
static JButton save = new JButton("Save");
static JButton load = new JButton("Load");
static JTextArea t = new JTextArea(100,100);
static String data = "C:\\Users\\dylan\\git\\level5-01-file-io-dylanvanwinkle\\src\\Checkpoint\\Save.dat";
static String text= "";
public static void main(String[] args) {
	run();
}

public static void setUp() {
	p.add(save);
	p.add(load);
	p.add(t);
	f.add(p);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setVisible(true);
	f.pack();
}

public static void run() {
setUp();
buttonsClicked();
}

public static void buttonsClicked() {
	save.addActionListener(e->{
		TextEditor t = new TextEditor();
save();
	});
	
load.addActionListener(e->{
		load();
	});
}

public static void save() {
try {
	FileWriter fw = new FileWriter(new File(data));
	
	fw.write(t.getText());
	
	fw.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

public static void load() {
try {
	FileReader fr = new FileReader(data);
	int c = fr.read();
	while(c != -1){
		text += (char)c;
		c = fr.read();
	}
	t.setText(text);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
