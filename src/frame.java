import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.io.File;


public class frame extends SudokuButtonGUI{
  public JPanel gui;
  public sideButtons buttons;
  public SudokuButtonGUI grid;
  public Menu menu;
  public File fileName;

  public frame(){
    gui = new JPanel(new BorderLayout());
    gui.setBorder(new EmptyBorder(2,3,2,3));

    buttons = new sideButtons();
    grid = new SudokuButtonGUI();
    menu = new Menu();
    menu.Open.addActionListener(new ActionListener(){
		@Override
     public void actionPerformed(ActionEvent actionEvent) {
				 JFileChooser fileChooser = new JFileChooser();

				 	fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

				int returnVal = fileChooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("You chose to open this file: " + fileChooser.getSelectedFile().getName());
				fileName = fileChooser.getSelectedFile();
				grid.changeGrid(fileName);
}

	}
});
    gui.add(menu.menuBar, BorderLayout.NORTH);
    gui.add(grid.gui, BorderLayout.WEST);
    gui.add(buttons.buttonPanel, BorderLayout.EAST);

  }

public void createFrame(){

  JFrame f = new JFrame("Demo");
  f.pack();
  f.setSize(700, 700);
  f.add(gui);

  f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

  f.setLocationByPlatform(true);

  f.pack();

  f.setVisible(true);

}


}
