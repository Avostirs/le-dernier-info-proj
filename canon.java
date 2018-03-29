import java.awt.Color;
//ici on importe la classe Graphics2D afin d'utiliser la methode rotate pour faire tourner notre canon
import java.awt.Graphics2D;					
import java.awt.Graphics;				
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

private  BufferedImage image;
private double alpha;           
private int i;

//Constructeur
public canon(double angle){
	alpha=angle;
    i=0;
    addKeyListener(this);
    
    //Lecture de l'image canon.png
	try{
		image = ImageIO.read(getClass().getResourceAsStream("./canon.png"));																		
	}catch(IOException e){
		e.printStackTrace();	
	}	
}

/**
* Permet d'appliquer la variation de l'ange du canon.
* @param e l'enevement qui se genere par l'appui d'une touche sur le clavier.
*/  
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
        
        
//Methodes a implementer mais inutiles        
public void actionPerformed(ActionEvent e){}
public void keyTyped(KeyEvent e){}
public void keyReleased(KeyEvent e){}


/**
Methode Paint pour dessiner le canon
 */ 
public void paint(Graphics g){
	//position du canon
	AffineTransform a = AffineTransform.getTranslateInstance(50,450);
	//rotation du canon
	a.rotate(-Math.toRadians(alpha)/4, image.getWidth()*0.1333,image.getHeight()/2);
	//mise à l'echelle du canon
	a.scale(0.5,0.5);
	//dessin de l'image avec un graphics 2D
	Graphics2D g2 = (Graphics2D) g;
	g2.drawImage(image,a,null);
	Toolkit.getDefaultToolkit().sync();			
}

/**
* Permet de faire varier la valeur de l'angle du canon.
* @param delta_alpha_voulu l'ecart d'angle applique a chaque implementation de la methode.
 */  
public void delta_angle(double delta_alpha_voulu){
		alpha= alpha + delta_alpha_voulu;
	}

//Methodes get
public double getangle(){
	return alpha;
}

public BufferedImage getimage(){
	return image;
}

}
		
