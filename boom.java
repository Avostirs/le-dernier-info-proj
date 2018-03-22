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






public class boom extends JPanel{//implements ActionListener{
	
	public int x;
	public int z;
	public ImageIcon[] tabimages;
//	public Timer t;
	public int j;
	public int s;
	public ImageIcon im;
	public JLabel l1;
	public JLabel l2;
	public JLabel l3;
	public JLabel l4;
	public JLabel l5;
	public JLabel l6;
	
	
	
	public boom(int x,int z){
		
	//	JLabel logo = new JLabel(new ImageIcon("./insa_logo.png"));
	//	logo.setBounds(190,20,140,130);
	//	t = new Timer(1000,this);
	
	
		j = 0;
		tabimages[0]= new ImageIcon("./photosboom/boom1.png");
		tabimages[1]= new ImageIcon("./photosboom/boom2.png");
		tabimages[2]= new ImageIcon("./photosboom/boom3.png");
		tabimages[3]= new ImageIcon("./photosboom/boom4.png");
		tabimages[4]= new ImageIcon("./photosboom/boom5.png");
		tabimages[5]= new ImageIcon("./photosboom/boom6.png");
		
		im= tabimages[j];
		
		this.x=x;
		this.z=z;
		tabimages = new ImageIcon[6];
		this.setBounds(this.x,this.z,400,400);
		l1 = new JLabel(tabimages[0]);
		l2 = new JLabel(tabimages[1]);
		l3 = new JLabel(tabimages[2]);
		l4 = new JLabel(tabimages[3]);															
		l5 = new JLabel(tabimages[4]);
		l6 = new JLabel(tabimages[5]);
		

	
	repaint();
}



public void addimage(int x,int z){
	this.add(l1);
	l1.setBounds(x,z,400,400);
}
	
}

	
	
	
	


	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
