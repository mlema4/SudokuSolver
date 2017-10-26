import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
 public class SudokuButtonGUI extends MiniSudokuButtonGUI
  {

   public JPanel gui;

   public  SudokuButtonGUI(){

   gui = new JPanel(new BorderLayout());
   gui.setBorder(new EmptyBorder(3, 3, 3, 3));

    //MiniSudokuButtonGUI sudokuGUI = new MiniSudokuButtonGUI();

   JPanel grid[][] = new JPanel [3] [3];
   for(int i=0; i<3; i++){
     for(int j=0; j<3; j++){
      MiniSudokuButtonGUI tmp = new MiniSudokuButtonGUI();
      grid[i][j] = tmp.gridP;
     }
  }

  JPanel sudokuGrid  = new JPanel(new GridLayout(3,3,5,5));
  for(int i=0; i<3; i++){
   for(int j=0; j<3; j++){
   sudokuGrid.add(grid[i][j]);
   }
  }
    gui.add(sudokuGrid, BorderLayout.LINE_END);

    //  JFrame f = new JFrame("Demo");
    //  f.pack();
    //  f.setSize(400, 400);
    //  f.add(gui);
    //
    // f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //
    // f.setLocationByPlatform(true);
    //
    // f.pack();
    //
    // f.setVisible(true);
    }

// public static void main(String[] args)
//   {
//     SudokuButtonGUI sudoku = new SudokuButtonGUI();
// //    sudoku.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//   }
}
