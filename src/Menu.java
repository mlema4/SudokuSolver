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

	public JMenu file, Help, Hint, Exit;

	//constructor
	public Menu() {

		//init menuBar
		//Menu menu= new Menu();

		//Menus on Board
		menuBar = new JMenuBar();
		file = new JMenu("File");
		//File.addMenuListener(new actionListener());


		Help = new JMenu("Help");
		//Help.addMenuListener(new actionListener());


		Hint = new JMenu("Hint");
		//Hint.addMenuListener(new actionListener());


		Exit = new JMenu("Exit");
		//Exit.addMenuListener(new actionListener());

		//File Menu SubMenus
		Open = new JMenuItem("Open a file");
		//Open.addMenuListener(new actionListener());
		file.add(Open);

		Save = new JMenuItem("Save game to file");
		//Save.addMenuListener(new actionListener());
		file.add(Save);

		Candidate = new JMenuItem("Candidate List");
		//Candidate.addMenuListener(new actionListener());
		file.add(Candidate);

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
		menuBar.add(file);
		menuBar.add(Exit);
		menuBar.add(Hint);
		menuBar.add(Help);

		//this.setJMenuBar(menuBar);

	}

	public void actionPerformed(ActionEvent e) {

	}


}
