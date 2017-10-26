import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;



public class frame extends SudokuButtonGUI{
  public JPanel gui;
  public sideButtons buttons;
  public SudokuButtonGUI grid;
  public Menu menu;

  public frame(){
    gui = new JPanel(new BorderLayout());
    gui.setBorder(new EmptyBorder(2,3,2,3));

    buttons = new sideButtons();
    grid = new SudokuButtonGUI();
    menu = new Menu();
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
