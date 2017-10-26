import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

public class Cell{
  public JButton cell;
  public int val;
  public String stringVal = ""; //Needed to change the string in the button;

  public Cell(){  
    cell = new JButton(stringVal);
  }


//If we modify the val we must modify the string val
//changing both in the same method ensures that we don't forget to change stringVal
  public void setVal (int val){
    this.val = val;
    this.stringVal = Integer.toString(val);
  }

  

}
