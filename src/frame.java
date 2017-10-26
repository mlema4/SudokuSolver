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

  public frame(){
    gui = new JPanel(new BorderLayout());
    gui.setBorder(new EmptyBorder(2,3,2,3));

    sideButtons buttons = new sideButtons();
    SudokuButtonGUI grid = new SudokuButtonGUI();

    gui.add(grid.gui, BorderLayout.WEST);
    gui.add(buttons.buttonPanel, BorderLayout.EAST);

  }


}
