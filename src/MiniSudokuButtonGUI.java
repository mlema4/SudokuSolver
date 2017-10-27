import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
public class MiniSudokuButtonGUI extends JFrame
{
 public Cell[][] jbutton;
 public JPanel gridP;

 public MiniSudokuButtonGUI()
 {
  jbutton = new Cell[3][3];
  gridP = new JPanel(new GridLayout(3,3,5,5));
  gridP.setBorder(new EmptyBorder(5,5,5,5));

    for (int i = 0; i < 3; i++) {
    	for(int j = 0; j < 3; j++) {
      Cell tmp = new Cell();
     jbutton[i][j]  = tmp;
     tmp.cell.setPreferredSize(new Dimension(50, 50));
     gridP.add(tmp.cell);
    	}
    }
 }

 // public static void main(String[] args)
 // {
 //   MiniSudokuButtonGUI m = new MiniSudokuButtonGUI();
 //    m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 // }
}
    