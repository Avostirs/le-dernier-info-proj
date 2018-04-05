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
import java.util.Random;
	


public class cible extends JPanel implements ActionListener  {				

private  BufferedImage image;
private double z ;
private Timer t2;
private boolean b;							
private double x;
private String chemin_de_limage;															
private int k;							
private long startS;
private int delta;							



//defintion du constructeur															
public cible(String chemin_image, int z1,int x1, int D){
	this.delta= D;
	z=z1;
	b=true;
	//ajout du timer qui va venir declencher notre actionPerformed 
	t2 = new Timer(1,this);								
	t2.start();
	x =x1;
	chemin_de_limage=chemin_image;
	k=2500;
	startS = 0;
			
	try{
		//stockage dans image du BufferedImage de la photo de l'avion
		image = ImageIO.read(getClass().getResourceAsStream(chemin_de_limage));																			//du chemin entre en parametre.
	
	}catch(IOException e){
		e.printStackTrace();
		
		
	}
	repaint();
}

/**
* Permet de modifier la position x de la cible suivant la variation de position "delta" voulu
* @param e l'enevement declenche par le timer
*/ 
public void actionPerformed(ActionEvent e){
	
	
	x= x - delta;
	//generation d'un nombre aleatoire entre 0 et le nombre passe en parametre a la methode .nextInt
	Random r = new Random();
    int n = r.nextInt(5);

	
	if(x<-200 && n==0){
		this.delta=2;
		x=k;
	this.setVisible(true);
}
	else if(x<-200 && n==1){
		this.delta = 1;
		x=k;
		this.setVisible(true);
	}

	repaint();
	revalidate();		
	
	
}

	
	

//methode pour dessiner notre cible
public void paint(Graphics g){
	
	AffineTransform a = AffineTransform.getTranslateInstance(x,z);
	
	Graphics2D g2 = (Graphics2D) g;
	
	g2.drawImage(image,a,null);
	
}


//methodes get des positions des extremites de la cible 

public double get_x_limite_gauche_de_limage(){
	return x+15;
}
public double get_x_limite_droite_de_limage(){
	return x+this.image.getWidth()-20;
}
public double get_z_limite_haut_de_limage(){
	return z+30;
}
public double get_z_limite_basse_de_limage(){
	return z+this.image.getHeight()-5;
}

public int get_x(){
	return (int)this.x;
}

public int get_z(){
	return (int)this.z;
}



}
	
