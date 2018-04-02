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
import java.util.TimerTask;
import java.util.Timer;




public class boom extends JLabel{
	
	public int x;
	public int z;
	public ImageIcon[] tabimages;
	
	public int j;
	
	
	
	public boom(int x,int z){
		
		
		tabimages = new ImageIcon[6];
		
		tabimages[0]= new ImageIcon("./photosboom/boom1.png");
		tabimages[1]= new ImageIcon("./photosboom/boom2.png");
		tabimages[2]= new ImageIcon("./photosboom/boom3.png");
		tabimages[3]= new ImageIcon("./photosboom/boom4.png");
		tabimages[4]= new ImageIcon("./photosboom/boom5.png");
		tabimages[5]= new ImageIcon("./photosboom/boom6.png");
		
		
		this.x=x;
		this.z=z;
		
		this.setBounds(x,z,1300,700);
		
	
	
		Timer timer = new Timer();
        
        action_timer action_a_repeter = new action_timer(timer, this); 
       //a  action_a_repeter va se reveiller a partir de l'instant 0 sec, toutes les 100 ms
        timer.schedule(action_a_repeter, 0, 100);					
		
				
	repaint();
}


public void set_imagei(int i){
	
	this.setIcon(tabimages[i]);
	
}

	

}

	
	
	
	


	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
