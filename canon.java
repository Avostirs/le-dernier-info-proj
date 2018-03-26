import java.awt.Color;
import java.awt.Graphics2D;					//ici on importe la classe Graphics2D afin d'utiliser la methode rotate pour faire tourner
import java.awt.Graphics;					//notre canon
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.io.IOException;	
import java.awt.geom.AffineTransform;	


public class canon extends JPanel implements KeyListener,ActionListener {	

public  BufferedImage image2;
private double alpha;            //une classe qui permet le maniement de l'image plus facilement
															//comme l'utilisation d'un drawImage, ou l'utilisation de la methode getGraphics()
															//qui renvoie le Graphics2D de l'image par exemple.
private int i;
public canon(double angle){
	
	alpha=angle;
    i=0;
    addKeyListener(this);
    
	try{
		
		//image = ImageIO.read(getClass().getResourceAsStream("./stock-vector-search-vector-icon-illustration-style-is-flat-iconic-black-symbol-on-a-transparent-background-582052531.jpg"));			//la classe ImageIO.read() renvoie le bufferedImage
		image2 = ImageIO.read(getClass().getResourceAsStream("./canon.png"));																			//du chemin entre en parametre.
	
	}catch(IOException e){
		e.printStackTrace();
		
		
	}
	repaint();
	revalidate();
}


public void keyPressed(KeyEvent e){
		char carac = e.getKeyChar();
		i = (int)(carac);
		if((i==119)&& (alpha<120)&&(alpha>=-60)){
			this.delta_angle(10);
			i=0;
		
		}else if((i==115)&& (alpha<=120)&&(alpha>-60)){
			this.delta_angle(-10);
			i=0;
			
			
	     }
	     
	     
	     repaint();
		}
        
        
        
public void actionPerformed(ActionEvent e){
		repaint();
		
		}

public void keyTyped(KeyEvent e){}
public void keyReleased(KeyEvent e){}







public void paint(Graphics g){
	
	AffineTransform a = AffineTransform.getTranslateInstance(50,450);
	
	a.rotate(-Math.toRadians(alpha)/4, image2.getWidth()*0.1333,image2.getHeight()/2);
	
	a.scale(0.5,0.5);					//		tres utile pour mettre a echelle notre canon, ici nous n'en avons pas besoin
	Graphics2D g2 = (Graphics2D) g;
	
	g2.drawImage(image2,a,null);
	
	
	
}


public void delta_angle(double delta_alpha_voulu){
		alpha= alpha + delta_alpha_voulu;
	}

public double getangle(){
	return alpha;
}

public BufferedImage getimage(){
	return image2;
}



}
		
