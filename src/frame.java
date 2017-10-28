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
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class frame extends SudokuButtonGUI{
  public JPanel gui;
  public sideButtons buttons;
  public SudokuButtonGUI grid;
  public Menu    menu;
  public File    fileName;
  public String  valueClicked = "";
  public JLabel  candidateList;
  public Boolean candidateListToggle = false;
  public Boolean EraserToggle = false;
  //public Boolean CheckOnFill = false;


  public frame(){
    candidateList = new JLabel("");
    gui = new JPanel(new BorderLayout());
    gui.setBorder(new EmptyBorder(2,3,2,3));

    buttons = new sideButtons();
    grid = new SudokuButtonGUI();
    menu = new Menu();
    menu.Open.addActionListener(new ActionListener(){
  		@Override
       public void actionPerformed(ActionEvent actionEvent) {
  				 JFileChooser fileChooser = new JFileChooser();
           File workingDirectory = new File(System.getProperty("user.dir"));
           fileChooser.setCurrentDirectory(workingDirectory);
  				 	fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

  				int returnVal = fileChooser.showOpenDialog(null);
  				if(returnVal == JFileChooser.APPROVE_OPTION) {
    				System.out.println("You chose to open this file: " + fileChooser.getSelectedFile().getName());
    				fileName = fileChooser.getSelectedFile();
            grid.initMiniGridRep();
            for(int i=0; i < 3;i++){
              for (int j=0;j<3; j++){
                grid.miniGrid[i][j].resetminiGridRep();
              }
            }
    				grid.changeGrid(fileName);



          }

	    }
    });

    for (int i =0; i<3;i++){
      for (int j =0; j<3;j++){
        setEventListeners(grid.miniGrid[i][j]);
      }
    }

    gui.add(menu.menuBar, BorderLayout.NORTH);
    gui.add(grid.gui, BorderLayout.WEST);
    gui.add(buttons.buttonPanel, BorderLayout.EAST);
    gui.add(candidateList, BorderLayout.SOUTH);

    for(int i =0; i<9; i++){
      buttons.buttons[i].addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent event){
        //  System.out.println(valueClicked);
          String name  = event.getActionCommand();
          valueClicked = name;
          candidateListToggle =false;
          EraserToggle = false;
         // System.out.println(valueClicked);
        }
      });

      buttons.buttons[10].addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent event){
          candidateListToggle = true;
          EraserToggle = false;
        }
      });
    }

    buttons.buttons[9].addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent actionEvent){
        valueClicked = " ";
       // System.out.println(valueClicked);
       candidateListToggle = false;
       EraserToggle = true;
      }
    });



  }
public void setEventListeners(MiniSudokuButtonGUI mini){
  for(int i =0; i<3; i++){
    for(int j =0; j<3; j++ ){
      Cell tmpCell = mini.getCell(i,j);
      if (!tmpCell.getlocked()){
      //  System.out.println("TESTFRAME");
        tmpCell.cell.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent actionEvent){
            //System.out.println("HELLO");
              ArrayList<String> tmp = getCandidateList(tmpCell.getxIndex(), tmpCell.getyIndex());
              String candidateListString = "";
              for(String val: tmp){
              candidateListString += val + " ";

              }
            if(candidateListToggle){
              candidateList.setText(candidateListString);
            }
            else{
              if(EraserToggle)  {
                if(!tmpCell.getlocked()){
                //  System.out.println(tmpCell.getlocked());
                getMiniGrid(tmpCell.getxIndex()+1,tmpCell.getyIndex()+1).miniGridRep.remove(tmpCell.cell.getText());
                grid.gridRep[tmpCell.getxIndex()][tmpCell.getyIndex()] = "0";
                tmpCell.cell.setText(valueClicked);
              //  System.out.println("HELLOFRAME");
                }
              }
              else if(menu.getCheckFillOn() && !tmpCell.getlocked()){
                if(tmp.contains(valueClicked)){
                  tmpCell.cell.setText(valueClicked);
                  grid.gridRep[tmpCell.getxIndex()][tmpCell.getyIndex()] = valueClicked;
                  //System.out.println("X: " + tmpCell.getxIndex() +
                  //"Y: " + tmpCell.getyIndex());
                  getMiniGrid(tmpCell.getxIndex()+1,tmpCell.getyIndex()+1).miniGridRep.add(valueClicked);
                }
                else if (!tmpCell.getlocked()){
                  frame frame = new frame();
                  JOptionPane.showMessageDialog(frame,
                  "Can not put " + valueClicked +
                  " in cell. Clcik the ? to check for possible options",
                    "Error", JOptionPane.ERROR_MESSAGE);
                }
              }
              else if(!tmpCell.getlocked()){
                tmpCell.cell.setText(valueClicked);
                grid.gridRep[tmpCell.getxIndex()][tmpCell.getyIndex()] = valueClicked;
                //System.out.println("X: " + tmpCell.getxIndex() +
                //"Y: " + tmpCell.getyIndex());
                getMiniGrid(tmpCell.getxIndex()+1,tmpCell.getyIndex()+1).miniGridRep.add(valueClicked);
              }
            }
            ArrayList<String> tmp1 = getCandidateList(tmpCell.getxIndex(), tmpCell.getyIndex());
            // for(String val: tmp1){
            //   System.out.print(val + " ");
            //
            // }
            // System.out.println();
            //grid.printGridRep();
            //getMiniGrid(tmpCell.getxIndex()+1,tmpCell.getyIndex()+1).printMiniGridRep();
          }
        });
      }
    }
  }

}

public ArrayList<String> getCandidateList(int x, int y){
  ArrayList<String> candidateList = new ArrayList<>();
  for(int i=1;i<10;i++){
    candidateList.add(Integer.toString(i));
  }

//get row
for(int i =0; i<9; i++){
  candidateList.remove(grid.gridRep[x][i]);
}
//get col

for(int i =0; i<9; i++){
  candidateList.remove(grid.gridRep[i][y]);
}
//get grid
  ArrayList<String> tmp = getMiniGrid(x+1,y+1).miniGridRep;
  for(String val: tmp){
    candidateList.remove(val);
  }
  return candidateList;
}

public MiniSudokuButtonGUI getMiniGrid(int row, int col)
{
  if(row <= 3) {
    if(col <= 3) {
      return grid.miniGrid[0][0];
      }
    else if(col <= 6) {
      return grid.miniGrid[0][1];
    }
    else if(col <= 9) {
      return grid.miniGrid[0][2];
    }
  }
  else if(row <= 6 && row >= 4) {
    if(col <= 3) {
        return grid.miniGrid[1][0];
      }
    else if(col <= 6) {
      return grid.miniGrid[1][1];
    }
    else if(col <= 9) {
      return grid.miniGrid[1][2];
    }
  }
  else if(row >= 7 && row <= 9) {
    if(col <= 3) {
      return grid.miniGrid[2][0];
      }
    else if(col <= 6) {
      return grid.miniGrid[2][1];

    }
    else if(col <= 9) {
      return grid.miniGrid[2][2];

    }
  }
  return null;
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
