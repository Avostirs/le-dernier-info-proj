import java.awt.Color;
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


public class balle extends JPanel implements ActionListener,KeyListener {	
		
//mesure du temps pour les equations
double startTime;
double elapsedTime = 0;
long startSpace;
long tempsSpace;

//declaration des attributs
public  BufferedImage image;
public double alpha;
public double x ;
public double z;
public double xinit;
public double zinit;
public Timer t1;
public int vo;
public double l;
public double L;	
final double g=9.81;
int i=0;
int j =0;
canon moncanon;
boolean b;
	

				

//constructeur
public balle(canon moncanon){
	
	
	
	//erreur systematique due a l'image : alpha est l'angle d'inclinaison reel
	this.moncanon=moncanon;
	alpha=moncanon.alpha-0.3*moncanon.alpha;
	b=true;
	
	//attributs largeur et longueur
	l=moncanon.image2.getWidth()*0.5*0.01;
	L=moncanon.image2.getHeight()*0.5*0.01;
	
	//attributs position
	x=(l*Math.cos(Math.toRadians(alpha))+0.50)*Math.pow(10,2);
	z=(4.50-L*Math.sin(Math.toRadians(alpha)))*Math.pow(10,2);
	
	// v0 : entree  clavier entre 4 et 15
	vo=5;
	
	//ajout du timer qui va venir declencher notre actionPerformed 
	t1 = new Timer(1,this);								
	//t1.start();	
	
	addKeyListener(this);
	
	//import de l'image	
	try{
		
		image = ImageIO.read(getClass().getResourceAsStream("./balle.png"));																			
	
	}catch(IOException e){
		e.printStackTrace();
		
		
	}
	this.setVisible(false);
	repaint();
}



//deplacement de la balle
public void keyPressed(KeyEvent e){
    System.out.println("Pressed");
    char carac = e.getKeyChar();
	i = (int)(carac);
	if (i==32 && b==true){
    startSpace=System.currentTimeMillis();
    i=0;
    b=false;
}
    
    
    }

public void keyReleased(KeyEvent e){
    
	System.out.println("Released");
	char carac = e.getKeyChar();
	j = (int)(carac);
    if (j==32 && b==false){
		this.setVisible(true);
		tempsSpace=System.currentTimeMillis()-startSpace;
		alpha=0.5*moncanon.alpha;//erreur systematique
		repaint();	
	
	if(!t1.isRunning()) {
		t1.start();
		startTime=System.currentTimeMillis();}
		else{
		startTime=System.currentTimeMillis();
		}
	repaint();
	i=0;
	b=true;
	
}
			
}

public void keyTyped(KeyEvent e){System.out.println("Typed");}

public void actionPerformed(ActionEvent e){
	//debug
	//System.out.println(x+" "+z);
    if(tempsSpace<200){
		vo=5;
	}else if(tempsSpace>=200 && tempsSpace<400){
		vo=7;
	}else if(tempsSpace>=400 && tempsSpace<800){
		vo=9;
	}else if(tempsSpace>=800 && tempsSpace<1000){
		vo=11;
	}else if(tempsSpace>=1000 && tempsSpace<1200){
		vo=12;
	}else if(tempsSpace>=1200 && tempsSpace<1400){
		vo=13;
	}else {
		vo=14;
	}
	
	System.out.println("voici le vo:"+vo);
	System.out.println("voici le tempsspace: "+tempsSpace);
		
	//
	elapsedTime = (System.currentTimeMillis() - startTime)*0.001;//temps ecoulé en secondes
	  
		x=(vo*Math.cos(Math.toRadians(alpha))*elapsedTime+(l*Math.cos(Math.toRadians(alpha))+0.50))*Math.pow(10,2); //1m=100pixels
		z=(0.5*g*Math.pow(elapsedTime,2)-vo*(Math.sin(Math.toRadians(alpha)))*elapsedTime+(4.50-L*Math.sin(Math.toRadians(alpha))))*Math.pow(10,2);

 
	repaint();	
			
}




	

//dessin de la balle
public void paint(Graphics g){
	
	AffineTransform a = AffineTransform.getTranslateInstance(x,z);
	a.scale(0.04,0.04);
	Graphics2D g2 = (Graphics2D) g;
	g2.drawImage(image,a,null);
	
	
}

public double get_centre_x(){
	return x+15;
}

public double get_centre_z(){
	return z+15;
}
}




	
