import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.util.ArrayList;

public class MiniSudokuButtonGUI extends JFrame
{
 public Cell[][] jbutton;
 public JPanel gridP;
 public ArrayList<String> miniGridRep;

 public MiniSudokuButtonGUI()
 {
   miniGridRep = new ArrayList<>();
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

 public void clearGrid(){
   for(int i =0; i<3; i++){
     for(int j=0; j<3; j++){
       jbutton[i][j].cell.setText("");
       jbutton[i][j].setlocked(false);
     }
   }
 }

 public void resetminiGridRep(){
   miniGridRep = new ArrayList<>();
 }
 public void printMiniGridRep(){
  //  System.out.println("Printig GRid MINI");
  //  for (String val : miniGridRep) {
  //    System.out.println(val);
  //  }
 }

 public Cell getCell(int i, int j){
   return jbutton[i][j];
 }

 public void addValueToGrid(String val){
   miniGridRep.add(val);
 }

 // public static void main(String[] args)
 // {
 //   MiniSudokuButtonGUI m = new MiniSudokuButtonGUI();
 //    m.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 // }
}
