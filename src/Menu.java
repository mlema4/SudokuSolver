import java.awt.*;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//import javax.swing.JButton;
import javax.swing.JFileChooser;
//import javax.swing.JFrame;
import java.io.File;
import java.io.FileWriter;

public class Menu implements ActionListener{

 public JMenuBar menuBar;

 public JMenuItem Open, Save, Exit, Candidate, SudInst, GameInst,
     About, Alg1, Alg2, Alg3, Alg4;

 public JCheckBoxMenuItem FillMode;
 public boolean fillselected;
 public JMenu file, Help, Hint;
 private Boolean CheckOnFill = false;

 //constructor
 public Menu() {

  //Menus on Board
  menuBar = new JMenuBar();
  file = new JMenu("File");
  //File.addMenuListener(new actionListener());


  Help = new JMenu("Help");
  //Help.addMenuListener(new actionListener());


  Hint = new JMenu("Hint");
  //Hint.addMenuListener(new actionListener());




  //File Menu SubMenus
  Open = new JMenuItem("Open a file");

  //Open.addMenuListener(new actionListener());
  file.add(Open);

  Save = new JMenuItem("Save game to file");
  //Save.addMenuListener(new actionListener());
  file.add(Save);

  Exit = new JMenuItem("Exit");
  Exit.addActionListener(this);
  file.add(Exit);

  Candidate = new JMenuItem("Candidate List");
  //Candidate.addMenuListener(new actionListener());
  file.add(Candidate);

  //Help Menu SubMenus
  SudInst = new JMenuItem("Sudoku Instructions");
  SudInst.addActionListener(this);
  Help.add(SudInst);

  GameInst = new JMenuItem("How to use Interface");
  GameInst.addActionListener(this);
  Help.add(GameInst);

  About = new JMenuItem("About the creators");
  About.addActionListener(this);
  Help.add(About);

  //Hint Menu SubMenus
  FillMode = new JCheckBoxMenuItem("Fill Mode");
  FillMode.addActionListener(this);
  Hint.add(FillMode);
  Alg1 = new JMenuItem("Single Alg");
  Hint.add(Alg1);
  Alg2 = new JMenuItem("Hidden Alg");
  Hint.add(Alg2);
  Alg3 = new JMenuItem("Locked Candidate");
  Hint.add(Alg3);
  Alg4 = new JMenuItem("Naked Pair");
  Hint.add(Alg4);
  menuBar.add(file);
  menuBar.add(Hint);
  menuBar.add(Help);

  //this.setJMenuBar(menuBar);
//  addSaveListener();

 }

 public void addSaveListener(String [][] gridRep){
   Save.addActionListener(new ActionListener(){
     @Override
     public void actionPerformed (ActionEvent actionEvent){
       JFileChooser chooser = new JFileChooser();
        File workingDirectory = new File(System.getProperty("user.dir"));
       chooser.setCurrentDirectory(workingDirectory);
       int retrival = chooser.showSaveDialog(null);
       if (retrival == JFileChooser.APPROVE_OPTION) {
           try {
               FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");
               for(int i=0; i<9; i++){
                 for(int j=0; j<9; j++){
                   if(!gridRep[i][j].equals("0")){
                  String info = Integer.toString(i+1) + " " + Integer.toString(j+1) +
                  " " + gridRep[i][j] + "\n";
                  fw.write(info);
                 }
               }
             }

               fw.close();
           } catch (Exception ex) {
               ex.printStackTrace();
           }
       }
     }
   });
 }

 public void actionPerformed(ActionEvent e) {
  frame box = new frame();
  if(e.getSource().equals(About)) {

   JOptionPane.showMessageDialog(box,"Creators:\nManuel Lema\n" + "Jin Wu\n" + "Timothy Yuen" );
  }
  else if(e.getSource().equals(SudInst)) {
   JOptionPane.showMessageDialog(box,"Fill the 9x9 grid so that each column, row, and 3x3 blocks contain\n"
     + "digits from 1 to 9. A cell is the smallest block in game. Each row\n"
     + "and column consists of 9 cells.");
  }
  else if(e.getSource().equals(GameInst)) {
   JOptionPane.showMessageDialog(box,"Select a value from the sidebar of 1-9 and fill the empty cells.\n"
     + "If you change your mind you can select eraser and remove values\n"
     + "of previous cells. Also by selecting an algorithm from hints \n"
     + "the first empty cell will be filled if possible by specific alg.\n");
  }

  else if(e.getSource().equals(Exit)) {
   System.exit(0);
   //box.setDefaultCloseOperation(JFrame.CLOSE_ON_CLOSE);
  }

  else if (e.getSource().equals(FillMode))
  {
    //fillselected = FillMode.isSelected();
   if(FillMode.isSelected())
   {
    JOptionPane.showMessageDialog(box, "Fill Mode has been toogled on.");
    CheckOnFill = true;
   }
   else
    CheckOnFill =false;
  }
 }

 public Boolean getCheckFillOn(){
   return CheckOnFill;
 }
}
