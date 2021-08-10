package _03_To_Do_List;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class ToDoList {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	static JFrame f = new JFrame();
	static JPanel p = new JPanel();
	static JButton b1 = new JButton("add task");
	static JButton b2 = new JButton("view tasks");
	static JButton b3 = new JButton("remove task");
	static JButton b4 = new JButton("save list");
	static JButton b5 = new JButton("load list");
	static ArrayList tasks = new ArrayList();
	static int counter = 0;
	public static void main(String[] args) {
run();
	}
	
	public static void cw() {
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		f.add(p);
		f.setVisible(true);
		f.pack();
	}
	public static void action(){
		b1.addActionListener(e-> 
		{String t = JOptionPane.showInputDialog("Please add a task.");
		tasks.add(t);});
		b2.addActionListener(e->{ 
		for (int i = 0; i < tasks.size(); i++) {
			JOptionPane.showMessageDialog(null, "Task " + (i + 1) + " is " + tasks.get((i)) + ".");	
		}});
		b3.addActionListener(e->{
			for (int i = 0; i < tasks.size(); i++) {
				JOptionPane.showMessageDialog(null, "Task " + (i + 1) + " is " + tasks.get((i)) + ".");}
			String temp = JOptionPane.showInputDialog("Enter task number you would like to remove.");
			int t2 = Integer.parseInt(temp);
			int t3 = t2 - 1;
			tasks.remove(t3);
		});
		b4.addActionListener(e->{
			try {
				FileWriter fw = new FileWriter(
						"src/_03_To_Do_List/List.txt");
				for (int i = 0; i < tasks.size(); i++) {
					counter ++;
					if (counter != (tasks.size() - 1)) {
						fw.write(tasks.get((i)) + "\n");
					}else {
						fw.write((int) tasks.get((i)));
					}
				}

				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		b5.addActionListener(e-> b5Run());
				
		}
		
				;
	
	
	public static void run() {
		startWith();
		cw();
		action();
	}
	
	public static void startWith() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"src/_03_To_Do_List/List.txt"));
			
			String line = br.readLine();
		
			while(line != null) {
				tasks.add(line);
				line = br.readLine();
			}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	
public static void b5Run() {
	String temp = JOptionPane.showInputDialog( "What is the location of the file you would like to load?(Have each task be on a seperate line.)");
	JFileChooser jfc = new JFileChooser();
	int returnVal = jfc.showOpenDialog(null);
	if (returnVal == JFileChooser.APPROVE_OPTION) {
		String fileName = jfc.getSelectedFile().getAbsolutePath();
		b5Reader(temp);
	}
}

public static void b5Reader(String s) {
	try {
		BufferedReader br = new BufferedReader(new FileReader(
				s));
		
		String line = br.readLine();
	
		while(line != null) {
			tasks.add(line);
			line = br.readLine();
		}
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
	}
