import java.awt.*;
import javax.swing.*;


public class fond extends JPanel {
	
	private Image image;
	
	//Constructeur:
	public fond () { 
		Toolkit T=Toolkit.getDefaultToolkit(); 
		// Import de l'image
		image = T.getImage("./fondquatre.jpg");	
		repaint();
	}
	
	//Méthode paint
	public void paint (Graphics g) {
		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		Toolkit.getDefaultToolkit().sync();
	}
	
}
