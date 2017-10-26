import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
public class MiniSudokuButtonGUI extends JFrame
{
 public JButton[] jbutton;
 public JPanel gridP;

 public MiniSudokuButtonGUI()
 {
  jbutton = new JButton[9];
  gridP = new JPanel(new GridLayout(3,3,5,5));
  gridP.setBorder(new EmptyBorder(5,5,5,5));

    for (int i = 0; i < 9; i++) {
      Cell tmp = new Cell();
     jbutton[i]  = tmp.cell;
     tmp.cell.setPreferredSize(new Dimension(50, 50));
     gridP.add(tmp.cell);
   }
 }

 // public static void main(String[] args)
 // {
 //   MiniSudokuButtonGUI m = new MiniSudokuButtonGUI();
 //    m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 // }
}
    