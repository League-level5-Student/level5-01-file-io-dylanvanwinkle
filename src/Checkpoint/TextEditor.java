package Checkpoint;

import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextEditor {
static JFrame f = new JFrame();
static JPanel p = new JPanel();
static JButton save = new JButton("Save");
static JButton load = new JButton("Load");
static JTextArea t = new JTextArea();

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
	
	});
	
load.addActionListener(e->{
		
	});
}
}
