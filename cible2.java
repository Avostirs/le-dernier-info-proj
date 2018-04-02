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
	


public class cible2 extends JPanel implements ActionListener  {				//un JPanel comme un autre

//public  BufferedImage image;
private  BufferedImage image2;
private double z ;
private Timer t2;
private boolean b;							//une classe qui permet le maniement de l'image plus facilement
private double x;
private String chemin_de_limage;															//comme l'utilisation d'un drawImage, ou l'utilisation de la methode getGraphics()
private int k;							
private long startS;
private int delta;							
															//qui renvoie le Graphics2D de l'image par exemple.
public cible2(String chemin_image, int z1,int x1, int D){
	this.delta= D;
	z=z1;
	b=true;
	t2 = new Timer(1,this);								//ajout du timer qui va venir declencher notre actionPerformed 
	t2.start();
	x =x1;
	chemin_de_limage=chemin_image;
	k=2500;
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

	
	


public void paint(Graphics g){
	
	AffineTransform a = AffineTransform.getTranslateInstance(x,z);
	
	
	//a.scale(0.13,0.13);						//	tres utile pour mettre a echelle notre cible
	Graphics2D g2 = (Graphics2D) g;
	
	g2.drawImage(image2,a,null);
	
}


public double get_x_limite_gauche_de_limage(){
	return x+15;
}
public double get_x_limite_droite_de_limage(){
	return x+this.image2.getWidth()-20;
}
public double get_z_limite_haut_de_limage(){
	return z+30;
}
public double get_z_limite_basse_de_limage(){
	return z+this.image2.getHeight()-5;
}

public int get_x(){
	return (int)this.x;
}

public int get_z(){
	return (int)this.z;
}



}
	
