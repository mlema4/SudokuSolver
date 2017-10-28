import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


 public class SudokuButtonGUI extends MiniSudokuButtonGUI
  {

   public JPanel gui;
   public JPanel [][]grid;
   public MiniSudokuButtonGUI[][] miniGrid;
   public String [][] gridRep ;

   public  SudokuButtonGUI(){
     gridRep = new String[9][9];
     initMiniGridRep();
     miniGrid = new MiniSudokuButtonGUI[3][3];


     gui = new JPanel(new BorderLayout());
     gui.setBorder(new EmptyBorder(3, 3, 3, 3));

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

     setLocation();
  }

    public void changeButton(int row, int col, int val){
      if(row <= 3) {
        row--;
        if(col <= 3) {
          col--;
          miniGrid[0][0].jbutton[row][col].setVal(val);
          miniGrid[0][0].addValueToGrid(Integer.toString(val));
          }
        else if(col <= 6) {
          col -= 4;
          miniGrid[0][1].jbutton[row][col].setVal(val);
          miniGrid[0][1].addValueToGrid(Integer.toString(val));
        }
        else if(col <= 9) {
          col -= 7;
          miniGrid[0][2].jbutton[row][col].setVal(val);
          miniGrid[0][2].addValueToGrid(Integer.toString(val));
        }
      }
      else if(row <= 6 && row >= 4) {
          row -= 4;
        if(col <= 3) {
          col--;
          miniGrid[1][0].jbutton[row][col].setVal(val);
          miniGrid[1][0].addValueToGrid(Integer.toString(val));
          }
        else if(col <= 6) {
          col -= 4;
          miniGrid[1][1].jbutton[row][col].setVal(val);
          miniGrid[1][1].addValueToGrid(Integer.toString(val));
        }
        else if(col <= 9) {
          col -= 7;
          miniGrid[1][2].jbutton[row][col].setVal(val);
          miniGrid[1][2].addValueToGrid(Integer.toString(val));
        }
      }
      else if(row >= 7 && row <= 9) {
          row -= 7;
        if(col <= 3) {
          col--;
          miniGrid[2][0].jbutton[row][col].setVal(val);
          miniGrid[2][0].addValueToGrid(Integer.toString(val));
          }
        else if(col <= 6) {
          col -= 4;
          miniGrid[2][1].jbutton[row][col].setVal(val);
          miniGrid[2][1].addValueToGrid(Integer.toString(val));

        }
        else if(col <= 9) {
          col -= 7;
          miniGrid[2][2].jbutton[row][col].setVal(val);
          miniGrid[2][2].addValueToGrid(Integer.toString(val));

        }
      }
    }

    public void updateGridRep(int i, int j, String val){
            gridRep[i][j] = val;
    }

    public void clearGrid(){
      for(int i =0; i<3; i++){
        for(int j=0; j<3; j++){
          miniGrid[i][j].clearGrid();
        }
      }
    }

    public void initMiniGridRep(){
      for(int i=0;i<9;i++){
        for (int j=0;j<9;j++){
          gridRep[i][j] = "0";
        }
      }
    }

    public void changeGrid(File filename) {
      try {

              Scanner inputFile = new Scanner (filename);
              clearGrid();
                    int row, col, val;

                    while(inputFile.hasNextInt()){
                      row = inputFile.nextInt();
                      col = inputFile.nextInt();
                      val = inputFile.nextInt();

                      changeButton(row, col, val);
                      updateGridRep(row-1, col-1, Integer.toString(val));
                      //System.out.println("WHILE TESTING SudokuButtonGUI");
                    }
                   // System.out.println("TESTING SudokuButtonGUI");
                   printGridRep();
                   printMiniGridRep();
          } catch (FileNotFoundException ex) {
              System.out.println("FILE NOT FOUND!");
          }

    }

    public void printGridRep(){
      for(int i=0;i<9;i++){
        for (int j=0;j<9;j++){
          System.out.print(gridRep[i][j] + " ");
        }
        System.out.println();
      }
    }

    public void printMiniGridRep(){
      for(int i=0;i<3;i++){
        for (int j=0;j<3;j++){
          miniGrid[i][j].printMiniGridRep() ;
        }
      //  System.out.println();
      }
    }

    public void setLocation(){
      for(int i=1; i<10; i++){
        for(int j=1; j<10; j++){
          setButtonLocation(i,j,i-1,j-1);
        }
     }
    }

    public void setButtonLocation(int row, int col, int x, int y){
      //System.out.println("Setting X:" + x + " and Y: " + y);
      if(row <= 3) {
        row--;
        if(col <= 3) {
          col--;
          miniGrid[0][0].jbutton[row][col].setxIndex(x);
          miniGrid[0][0].jbutton[row][col].setyIndex(y);
        //  System.out.println("TESTSUDOKU");
          }
        else if(col <= 6) {
          col -= 4;
          miniGrid[0][1].jbutton[row][col].setxIndex(x);
          miniGrid[0][1].jbutton[row][col].setyIndex(y);
        }
        else if(col <= 9) {
          col -= 7;
          miniGrid[0][2].jbutton[row][col].setxIndex(x);
          miniGrid[0][2].jbutton[row][col].setyIndex(y);;
        }
      }
      else if(row <= 6 && row >= 4) {
          row -= 4;
        if(col <= 3) {
          col--;
          miniGrid[1][0].jbutton[row][col].setxIndex(x);
          miniGrid[1][0].jbutton[row][col].setyIndex(y);
          }
        else if(col <= 6) {
          col -= 4;
          miniGrid[1][1].jbutton[row][col].setxIndex(x);
          miniGrid[1][1].jbutton[row][col].setyIndex(y);
        }
        else if(col <= 9) {
          col -= 7;
          miniGrid[1][2].jbutton[row][col].setxIndex(x);
          miniGrid[1][2].jbutton[row][col].setyIndex(y);
        }
      }
      else if(row >= 7 && row <= 9) {
          row -= 7;
        if(col <= 3) {
          col--;
          miniGrid[2][0].jbutton[row][col].setxIndex(x);
          miniGrid[2][0].jbutton[row][col].setyIndex(y);
          }
        else if(col <= 6) {
          col -= 4;
          miniGrid[2][1].jbutton[row][col].setxIndex(x);
          miniGrid[2][1].jbutton[row][col].setyIndex(y);

        }
        else if(col <= 9) {
          col -= 7;
          miniGrid[2][2].jbutton[row][col].setxIndex(x);
          miniGrid[2][2].jbutton[row][col].setyIndex(y);

        }
      }
    }

}
