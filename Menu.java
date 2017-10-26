import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//import javax.swing.JButton;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;

public class Menu{
	
	public JMenuBar menuBar;
	
	public JMenuItem Open, Save, Candidate, SudInst, GameInst,
			  About;
	
	public JCheckBoxMenuItem Alg1, Alg2, Alg3, Alg4;
	
	public JMenu File, Help, Hint, Exit;
	
	//constructor
	public Menu() {
		
		//init menuBar
		Menu menu= new Menu();
		
		//Menus on Board
		File = new JMenu("File");
		//File.addMenuListener(new actionListener());
		menuBar.add(File);
		
		Help = new JMenu("Help");
		//Help.addMenuListener(new actionListener());
		menuBar.add(Help);
		
		Hint = new JMenu("Hint");
		//Hint.addMenuListener(new actionListener());
		menuBar.add(Hint);
		
		Exit = new JMenu("Exit");
		//Exit.addMenuListener(new actionListener());
		menuBar.add(Exit);
		
		//File Menu SubMenus
		Open = new JMenuItem("Open a file");
		//Open.addMenuListener(new actionListener());
		File.add(Open);
		
		Save = new JMenuItem("Save game to file");
		//Save.addMenuListener(new actionListener());
		File.add(Save);
		
		Candidate = new JMenuItem("Candidate List");
		//Candidate.addMenuListener(new actionListener());
		File.add(Candidate);
		
		//Help Menu SubMenus
		SudInst = new JMenuItem("Sudoku Instructions");
		//SudInst.addMenuListener(new actionListener());
		Help.add(SudInst);
		
		GameInst = new JMenuItem("How to use Interface");
		//GameInst.addMenuListener(new actionListener());
		Help.add(GameInst);
		
		About = new JMenuItem("About the creators");
		//About.addMenuListener(new actionListener());
		Help.add(About);
		
		//Hint Menu SubMenus
		Alg1 = new JCheckBoxMenuItem("Single Alg");
		Hint.add(Alg1);
		Alg2 = new JCheckBoxMenuItem("Hidden Alg");
		Hint.add(Alg2);
		Alg3 = new JCheckBoxMenuItem("Locked Candidate");
		Hint.add(Alg3);
		Alg4 = new JCheckBoxMenuItem("Naked Pair");
		Hint.add(Alg4);
		
		//this.setJMenuBar(menuBar);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}


}
