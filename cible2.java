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
public double x;
public String chemin_de_limage;															//comme l'utilisation d'un drawImage, ou l'utilisation de la methode getGraphics()
public int k;							
private long startS;							
															//qui renvoie le Graphics2D de l'image par exemple.
public cible2(String chemin_image, int z1,int x1){
	z=z1;
	b=true;
	t2 = new Timer(1,this);								//ajout du timer qui va venir declencher notre actionPerformed 
	t2.start();
	x =x1;
	chemin_de_limage=chemin_image;
	k=4000;
	startS = 0;
			
	try{
		
		//image = ImageIO.read(getClass().getResourceAsStream("./stock-vector-search-vector-icon-illustration-style-is-flat-iconic-black-symbol-on-a-transparent-background-582052531.jpg"));			//la classe ImageIO.read() renvoie le bufferedImage
		image2 = ImageIO.read(getClass().getResourceAsStream(chemin_de_limage));																			//du chemin entre en parametre.
	
	}catch(IOException e){
		e.printStackTrace();
		
		
	}
	repaint();
}

public void actionPerformed(ActionEvent e){
	
//	if(x<1300 && x>0){
	x--;

	startS=startS+1;
	
	if(x==-100){
		x=k;
	this.setVisible(true);
}


	if(this.startS>1000 && this.startS<5000){
		k=3000;
	}
	if(this.startS>5000 && this.startS<10000){
		k=1400;
	}

	
	/*
	if(x==0){
		if(b==true){
			b=false;
		}
	}else if(x==50){
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
	 */
	repaint();
	revalidate();		
	
	
}
	
	


public void paint(Graphics g){
	
	AffineTransform a = AffineTransform.getTranslateInstance(x,z);
	
	
	//a.scale(0.13,0.13);						//	tres utile pour mettre a echelle notre cible
	Graphics2D g2 = (Graphics2D) g;
	
	g2.drawImage(image2,a,null);
	g.setColor(Color.blue);
	g.fillRect((int)this.get_x_limite_gauche_de_limage(),(int)this.get_z_limite_haut_de_limage(),10,10);
	
	
	
}


public double get_x_limite_gauche_de_limage(){
	return x+14;
}
public double get_x_limite_droite_de_limage(){
	return x+this.image2.getWidth()-20;
}
public double get_z_limite_haut_de_limage(){
	return z+30;
}
public double get_z_limite_basse_de_limage(){
	return z+this.image2.getHeight()-10;
}


}
	
