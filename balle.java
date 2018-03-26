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
private boolean s;
	

				

//constructeur
public balle(canon moncanon){
	
	s=true;
	
	
	
	//erreur systematique due a l'image : alpha est l'angle d'inclinaison reel
	this.moncanon=moncanon;
	alpha=moncanon.getangle()-0.3*moncanon.getangle();
	b=true;
	
	//attributs largeur et longueur
	l=moncanon.image2.getWidth()*0.5*0.01;
	L=moncanon.image2.getHeight()*0.5*0.01;
	
	//attributs position
	x=(l*Math.cos(Math.toRadians(alpha))+0.50)*Math.pow(10,2);
	z=(4.50-L*Math.sin(Math.toRadians(alpha)))*Math.pow(10,2);
	
	// v0 : entree  clavier entre 4 et 15
	vo=0;
	
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
    
    char carac = e.getKeyChar();
	i = (int)(carac);
	if (i==32 && b==true){
    startSpace=System.currentTimeMillis();
    i=0;
    b=false;
}
    
    
    }

public void keyReleased(KeyEvent e){
    
	
	char carac = e.getKeyChar();
	j = (int)(carac);
    if (j==32 && b==false){
		this.setVisible(true);
		tempsSpace=System.currentTimeMillis()-startSpace;
		alpha=0.5*moncanon.getangle();//erreur systematique
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
	this.s=false;
	
}
			
}

public void keyTyped(KeyEvent e){}

public void actionPerformed(ActionEvent e){
	//debug
	//System.out.println(x+" "+z);
    if(tempsSpace<200 &&tempsSpace>0){
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
	
	//affichage du cadre

		g2.setStroke(new BasicStroke(4));
		g.setColor(Color.black);
		g.drawRect(5,608,257,40);
	
		g2.setStroke(new BasicStroke(2));
		
		//affichage de la jauge en fonction de vo
		if(vo>0 && vo<=5){
			// Premier carré
			g.setColor(Color.black);
			g.drawRect(9,612,32,32);
			g.setColor(Color.green);
			g.fillRect(11,614,28,28);
		}	
		else if(vo>5 && vo<=7){
			//Premier carré
			g.setColor(Color.black);
			g.drawRect(9,612,32,32);
			g.setColor(Color.green);
			g.fillRect(11,614,28,28);
			//Deuxième carré	
			g.setColor(Color.black);
			g.drawRect(45,612,32,32);
			g.setColor(Color.green);
			g.fillRect(47,614,28,28);
		}	
		else if(vo>7 && vo<=9){
			//Premier carré
			g.setColor(Color.black);
			g.drawRect(9,612,32,32);
			g.setColor(Color.green);
			g.fillRect(11,614,28,28);
			//Deuxième carré	
			g.setColor(Color.black);
			g.drawRect(45,612,32,32);
			g.setColor(Color.green);
			g.fillRect(47,614,28,28);
			//Troisème carré
			g.setColor(Color.black);
			g.drawRect(81,612,32,32);
			g.setColor(Color.green);
			g.fillRect(83,614,28,28);
		}
		else if(vo>9 && vo<=11){
			//Premier carré
			g.setColor(Color.black);
			g.drawRect(9,612,32,32);
			g.setColor(Color.green);
			g.fillRect(11,614,28,28);
			//Deuxième carré	
			g.setColor(Color.black);
			g.drawRect(45,612,32,32);
			g.setColor(Color.green);
			g.fillRect(47,614,28,28);
			//Troisème carré
			g.setColor(Color.black);
			g.drawRect(81,612,32,32);
			g.setColor(Color.green);
			g.fillRect(83,614,28,28);
			//Quatrième carré
			g.setColor(Color.black);
			g.drawRect(117,612,32,32);
			g.setColor(Color.yellow);
			g.fillRect(119,614,28,28);	
		}
		else if(vo>11 && vo<=12){
			//Premier carré
			g.setColor(Color.black);
			g.drawRect(9,612,32,32);
			g.setColor(Color.green);
			g.fillRect(11,614,28,28);
			//Deuxième carré	
			g.setColor(Color.black);
			g.drawRect(45,612,32,32);
			g.setColor(Color.green);
			g.fillRect(47,614,28,28);
			//Troisème carré
			g.setColor(Color.black);
			g.drawRect(81,612,32,32);
			g.setColor(Color.green);
			g.fillRect(83,614,28,28);
			//Quatrième carré
			g.setColor(Color.black);
			g.drawRect(117,612,32,32);
			g.setColor(Color.yellow);
			g.fillRect(119,614,28,28);
			//Cinquième carré
			g.setColor(Color.black);
			g.drawRect(153,612,32,32);
			g.setColor(Color.yellow);
			g.fillRect(155,614,28,28);
		}
		else if(vo>12 && vo<=13){
			//Premier carré
			g.setColor(Color.black);
			g.drawRect(9,612,32,32);
			g.setColor(Color.green);
			g.fillRect(11,614,28,28);
			//Deuxième carré	
			g.setColor(Color.black);
			g.drawRect(45,612,32,32);
			g.setColor(Color.green);
			g.fillRect(47,614,28,28);
			//Troisème carré
			g.setColor(Color.black);
			g.drawRect(81,612,32,32);
			g.setColor(Color.green);
			g.fillRect(83,614,28,28);
			//Quatrième carré
			g.setColor(Color.black);
			g.drawRect(117,612,32,32);
			g.setColor(Color.yellow);
			g.fillRect(119,614,28,28);
			//Cinquième carré
			g.setColor(Color.black);
			g.drawRect(153,612,32,32);
			g.setColor(Color.yellow);
			g.fillRect(155,614,28,28);
			//Sixième carré
			g.setColor(Color.black);
			g.drawRect(189,612,32,32);
			g.setColor(Color.yellow);
			g.fillRect(191,614,28,28);
		}
		else if(vo>13 && vo<=14){
			//Premier carré
			g.setColor(Color.black);
			g.drawRect(9,612,32,32);
			g.setColor(Color.green);
			g.fillRect(11,614,28,28);
			//Deuxième carré	
			g.setColor(Color.black);
			g.drawRect(45,612,32,32);
			g.setColor(Color.green);
			g.fillRect(47,614,28,28);
			//Troisème carré
			g.setColor(Color.black);
			g.drawRect(81,612,32,32);
			g.setColor(Color.green);
			g.fillRect(83,614,28,28);
			//Quatrième carré
			g.setColor(Color.black);
			g.drawRect(117,612,32,32);
			g.setColor(Color.green);
			g.fillRect(119,614,28,28);
			//Cinquième carré
			g.setColor(Color.black);
			g.drawRect(153,612,32,32);
			g.setColor(Color.yellow);
			g.fillRect(155,614,28,28);
			//Sixième carré
			g.setColor(Color.black);
			g.drawRect(189,612,32,32);
			g.setColor(Color.yellow);
			g.fillRect(191,614,28,28);
			//Septième carré
			g.setColor(Color.black);
			g.drawRect(225,612,32,32);
			g.setColor(Color.red);
			g.fillRect(227,614,28,28);
		}
		repaint();
	}
	
	

public double get_centre_x(){
	return x+15;
}

public double get_centre_z(){
	return z+15;
}
public void setboolean_s(boolean f){
	s=f;
}
public boolean getboolean_s(){
	return s;
}																																																		
	



}




	
