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
private double startTime;
private double elapsedTime = 0;
private long startSpace;
private long tempsSpace;


//declaration des attributs
private  BufferedImage image;
private double alpha;
private double x ;
private double z;
private double xinit;
private double zinit;
private Timer t1;
private int vo;
private double l;
private double L;	
final double g=9.81;
private int i=0;
private int j =0;
canon moncanon;
private boolean b;
private boolean s;
	

				

//constructeur
public balle(canon moncanon){
	s=true;
	//erreur systematique due a l'image : alpha est l'angle d'inclinaison reel
	this.moncanon=moncanon;
	alpha=moncanon.getangle()-0.3*moncanon.getangle();
	b=true;
	
	//attributs largeur et longueur
	l=moncanon.getimage().getWidth()*0.5*0.01;
	L=moncanon.getimage().getHeight()*0.5*0.01;
	
	//attributs position
	x=(l*Math.cos(Math.toRadians(alpha))+0.50)*Math.pow(10,2);
	z=(4.50-L*Math.sin(Math.toRadians(alpha)))*Math.pow(10,2);
	
	// v0 : entree  clavier (peut varier entre 0 et 15)
	vo=0;
	
	//ajout du timer qui va venir declencher notre actionPerformed 
	t1 = new Timer(1,this);								
	
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

public void keyPressed(KeyEvent e){
// Déplacement de la balle
// Démarrage du timer lorsqu'on appuie sur la barre espace du clavier
char carac = e.getKeyChar();
	i = (int)(carac);
	if (i==32 && b==true){
	    startSpace=System.currentTimeMillis();
	    i=0;
	    b=false;
	}
}


// Méthode keyReleased:
public void keyReleased(KeyEvent e){
	char carac = e.getKeyChar();
	j = (int)(carac);
    	if (j==32 && b==false){
            //Affichage de la balle
            this.setVisible(true);
            tempsSpace=System.currentTimeMillis()-startSpace;
	    	//Correction de l'erreur systematique
            alpha=0.5*moncanon.getangle();//erreur systematique
            repaint();	
        
		if(!t1.isRunning()) {
			t1.start();
			startTime=System.currentTimeMillis();
		}
		else{
			startTime=System.currentTimeMillis();
		}
		repaint();
		i=0;
		b=true;
		this.s=false;
	
        }			
}

//Méthode keyTyped
public void keyTyped(KeyEvent e){}

//Méthode actionPerformed
public void actionPerformed(ActionEvent e){
	// On incrémente vo en fonction du temps d'appui sur la barre espace
	deterv0();
    
	//temps ecoulé en secondes	
	elapsedTime = (System.currentTimeMillis() - startTime)*0.001;
	// Equations du PFD (on a pris comme échelle 1m=100 pixels)
	trajectoireballe();	
	repaint();	
			
}

//Méthode paint
public void paint(Graphics g){
	
	//Dessin de la balle
	AffineTransform a = AffineTransform.getTranslateInstance(x,z);
	a.scale(0.04,0.04);
	Graphics2D g2 = (Graphics2D) g;
	g2.drawImage(image,a,null);
    
    jaugev0(g,g2);
	
	//Dessin de la barre de puissance
	//Affichage du cadre:
	g2.setStroke(new BasicStroke(4));
	g.setColor(Color.black);
	g.drawRect(5,608,257,40);
	g2.setStroke(new BasicStroke(2));
    
	Toolkit.getDefaultToolkit().sync();
	repaint();
	
	
}	
    
 
public void trajectoireballe(){
    x=(vo*Math.cos(Math.toRadians(alpha))*elapsedTime+(l*Math.cos(Math.toRadians(alpha))+0.50))*Math.pow(10,2);
    z=(0.5*g*Math.pow(elapsedTime,2)-vo*(Math.sin(Math.toRadians(alpha)))*elapsedTime+(4.50-L*Math.sin(Math.toRadians(alpha))))*Math.pow(10,2);
}  

public void jaugev0(Graphics g,Graphics g2){
    
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
            //Septième carré
            g.setColor(Color.black);
            g.drawRect(225,612,32,32);
            g.setColor(Color.red);
            g.fillRect(227,614,28,28);
        }
}
      
 public void deterv0(){ 
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
 }
 
     
//Méthodes get
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




	
