import java.awt.*;
import javax.swing.*;


public class fond extends JPanel {
	
	public Image image;
	
	public fond () {
	Toolkit T=Toolkit.getDefaultToolkit();
	image = T.getImage("./fondquatre.jpg");	
	repaint();
	}

	public void paint (Graphics g) {
	g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
}
