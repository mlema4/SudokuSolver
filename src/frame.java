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


public class frame extends SudokuButtonGUI{
  public JPanel gui;
  public sideButtons buttons;
  public SudokuButtonGUI grid;
  public Menu menu;
  public File fileName;
  public String valueClicked;



  public frame(){
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
    				grid.changeGrid(fileName);

            for (int i =0; i<3;i++){
              for (int j =0; j<3;j++){
                setEventListeners(grid.miniGrid[i][j]);
              }
            }

          }

	    }
    });

    gui.add(menu.menuBar, BorderLayout.NORTH);
    gui.add(grid.gui, BorderLayout.WEST);
    gui.add(buttons.buttonPanel, BorderLayout.EAST);

    for(int i =0; i<9; i++){
      buttons.buttons[i].addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent event){
        //  System.out.println(valueClicked);
          String name  = event.getActionCommand();
          valueClicked = name;
         // System.out.println(valueClicked);
        }
      });
    }

    buttons.buttons[9].addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent actionEvent){
        valueClicked = " ";
       // System.out.println(valueClicked);
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
            tmpCell.cell.setText(valueClicked);
          }
        });
      }
    }
  }

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
