import java.awt.*;
import javax.swing.*;


public class fond_boom extends JPanel {
	
	
	public fond_boom () {
	
	this.setBounds(0,0,1300,700); 
		
	repaint();
	}

	public void add_explosion(int x,int z){
		boom b = new boom(x,z);
		this.add(b);
		
		repaint();
	}
		
	
}
