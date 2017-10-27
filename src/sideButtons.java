import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class sideButtons {
  public JPanel buttonColumn;
  public JPanel buttonPanel;
  public JButton[] buttons;


  public sideButtons(){
   buttonColumn = new JPanel(new GridBagLayout());
   buttonColumn.setBorder(new EmptyBorder(5,5,5,5));
   buttonPanel = new JPanel(new GridLayout(0,1,5,5));
   buttons = new JButton[10];
   for (int i = 1; i < 10; i++) {
     JButton tmp = new JButton("" + i);
     tmp.setPreferredSize(new Dimension(50, 50));
     buttons[i-1] = tmp;
     buttonPanel.add(tmp);
   }

   JButton eraser = new JButton();
   buttons[9] = eraser;
   eraser.setPreferredSize(new Dimension(50, 50));
  try {
    Image img = ImageIO.read(getClass().getResource("eraser.png"));
   Image newimg = img.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH ) ;
    eraser.setIcon(new ImageIcon(newimg));
  } catch (Exception ex) {
    System.out.println(ex);
  }
  buttonPanel.add(eraser);

   buttonColumn.add(buttonPanel);
}

}
