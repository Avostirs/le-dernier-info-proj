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


public class cible2 extends JPanel implements ActionListener  {				//un JPanel comme un autre

//public  BufferedImage image;
public  BufferedImage image2;
public double z ;
public Timer t2;
public boolean b;							//une classe qui permet le maniement de l'image plus facilement
															//comme l'utilisation d'un drawImage, ou l'utilisation de la methode getGraphics()
															//qui renvoie le Graphics2D de l'image par exemple.
public cible2(){
	z=0;
	b=true;
	t2 = new Timer(1,this);								//ajout du timer qui va venir declencher notre actionPerformed 
	t2.start();		
	try{
		
		//image = ImageIO.read(getClass().getResourceAsStream("./stock-vector-search-vector-icon-illustration-style-is-flat-iconic-black-symbol-on-a-transparent-background-582052531.jpg"));			//la classe ImageIO.read() renvoie le bufferedImage
		image2 = ImageIO.read(getClass().getResourceAsStream("./bonhomme.png"));																			//du chemin entre en parametre.
	
	}catch(IOException e){
		e.printStackTrace();
		
		
	}
	repaint();
}

public void actionPerformed(ActionEvent e){
	
	
	if(z==500){
		if(b==true){
			b=false;
		}
	}else if(z==0){
		if(b==false){
			b=true;
		}
	}
	if(b==true){
		z++;
		repaint();
		validate();
	}else if(b==false){
		z--;
		repaint();
		validate();
	}
	repaint();
	revalidate();		
	
	
}
	
	


public void paint(Graphics g){
	
	AffineTransform a = AffineTransform.getTranslateInstance(1150,z);
	
	
	a.scale(0.13,0.13);						//	tres utile pour mettre a echelle notre cible
	Graphics2D g2 = (Graphics2D) g;
	
	g2.drawImage(image2,a,null);
	
	
}

public double getz(){
	return z;
}




}
	
