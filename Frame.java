import javax.swing.JFrame;

public class Frame extends JFrame{
	
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Frame");
		// TODO Auto-generated method stub
		Menu TopMenu = new Menu();
		frame.add(TopMenu);
	}
}
