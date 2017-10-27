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
   public JPanel [][]grid;
   public MiniSudokuButtonGUI[][] miniGrid;
   
   
   public  SudokuButtonGUI(){

	   
   miniGrid = new MiniSudokuButtonGUI[3][3];
   
   gui = new JPanel(new BorderLayout());
   gui.setBorder(new EmptyBorder(3, 3, 3, 3));

    //MiniSudokuButtonGUI sudokuGUI = new MiniSudokuButtonGUI();
   
    grid = new JPanel [3] [3];
   for(int i=0; i<3; i++){
     for(int j=0; j<3; j++){
      MiniSudokuButtonGUI tmp = new MiniSudokuButtonGUI();
      miniGrid[i][j] = tmp;
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
    
 // find the row and column to add values in grid
 // Manny send the row and column
    int row = 5; 
    int col = 6; 
    int val = 0;
    miniGrid[0][0].jbutton[0][0].setVal(val);
    if(row <= 3) {
    	row--;
    	if(col <= 3) {
    		col--;
    		miniGrid[0][0].jbutton[row][col].setVal(val);
    		}
    	else if(col <= 6) {
    		col -= 4;
    		miniGrid[0][1].jbutton[row][col].setVal(val);
    	}
    	else if(col <= 9) {
    		col -= 7;
    		miniGrid[0][2].jbutton[row][col].setVal(val);
    	}
    }
    else if(row <= 6 && row >= 4) {
    		row -= 4;
    	if(col <= 3) {
    		col--;
    		miniGrid[1][0].jbutton[row][col].setVal(val);
    		}
    	else if(col <= 6) {
    		col -= 4;
    		miniGrid[1][1].jbutton[row][col].setVal(val);
    	}
    	else if(col <= 9) {
    		col -= 7;
    		miniGrid[1][2].jbutton[row][col].setVal(val);
    	}
    }
    else if(row >= 7 && row <= 9) {
    		row -= 7;
    	if(col <= 3) {
    		col--;
    		miniGrid[2][0].jbutton[row][col].setVal(val);
    		}
    	else if(col <= 6) {
    		col -= 4;
    		miniGrid[2][1].jbutton[row][col].setVal(val);
    	}
    	else if(col <= 9) {
    		col -= 7;
    		miniGrid[2][2].jbutton[row][col].setVal(val);
    	}
    }
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
