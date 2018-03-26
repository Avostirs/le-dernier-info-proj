import java.awt.Color;
import java.awt.Graphics2D;					//ici on importe la classe Graphics2D afin d'utiliser la methode rotate pour faire tourner
import java.awt.Graphics;					//notre canon
import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.io.IOException;	
import java.awt.geom.AffineTransform;	
import java.util.*;


public class interfacegraphique extends JFrame implements KeyListener,ActionListener {


		private Timer t;
		private int i;
		public JPanel p;
		public canon conteneur;
	//	public cible2 conteneurcible;
		public balle conteneurballe;
		public fond conteneurfond;
		ArrayList<cible2> collectioncibles;
		public long starttime;
		public long temps;
		int decompte=18000;
		FinDuJeu fin;
		public int k=0;
	
	public interfacegraphique(){
		
		i=0;
		
		
		//definition de la fenetre
		this.setTitle(" A vos Tirs!");
		this.setLayout(null);
		this.setSize(1300,700);
		this.setLocation(30,30);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setVisible(true);
		
		//creationfindujeu
		
		//fin.setVisible(false);
		
		//ajout du timer qui va venir declencher notre actionPerformed toutes les 5 millisecondes
		t = new Timer(5,this);
		t.start();													
		
		addKeyListener(this);
		
		collectioncibles = new ArrayList<cible2>();
		this.ajoutercible(200,1300);
		this.ajoutercible(100,1500);
		this.ajoutercible(300,1800);
		
	//les conteneurs canon et cibles font office de calque que l'on met dans le conteneur principal
	
		//definition de la cible
		
		
		//definition du canon
		conteneur = new canon(40);
		conteneur.setLayout(null);
		conteneur.setBounds(0,0,1300,600);
		
		//definition de la balle
		conteneurballe=new balle(conteneur);
		conteneurballe.setLayout(null);
		conteneurballe.setBounds(0,0,1300,600);
		
		//ajout de l'image de fond
		conteneurfond = new fond();
		conteneurfond.setLayout(null);
		conteneurfond.setBounds(0,0,1300,600); 
		
	
		//definition du conteneur principal

		p = new JPanel();
		p.setLayout(null);
		this.setContentPane(p);
		p.setBounds(100,100,this.getWidth(),this.getHeight());
		p.add(conteneur);
		for(cible2 conteneurcible: collectioncibles){
			
			conteneurcible.setLayout(null);
			conteneurcible.setBounds(0,0,1300,600);
			p.add(conteneurcible);
	}
		p.add(conteneurballe); 
		p.add(conteneurfond); 
		this.addKeyListener(conteneurballe);
		this.addKeyListener(conteneur);
		p.revalidate();
		p.validate();
		validate();
		repaint();	
		
		starttime = System.currentTimeMillis();
		
		
	}
	
		public void keyPressed(KeyEvent e){ 
	     
	     repaint();
		}
	
		public void actionPerformed(ActionEvent e){
			
		for(cible2 conteneurcible : collectioncibles){	
			
		
		if(this.touche_cible(conteneurcible)==true && this.conteneurballe.getboolean_s()== false ){
			
			conteneurcible.setVisible(false);
			this.conteneurballe.setVisible(false);
			this.conteneurballe.setboolean_s(true);
			k=k+1;
		System.out.println(k+" voici le k");
		repaint();
	}
	}
	//Affichage du decompte
	if(this.isVisible()){
	this.setTitle(((decompte)*5/1000)+"       A vos Tirs!");
	repaint();
	decompte = decompte -30;
	if((decompte==0) ){
		fin=new FinDuJeu(k);
		//fin.setp(k);
	//	fin.setVisible(false);
		revalidate();
		validate();
		this.setVisible(false);
		fin.setVisible(true);
		
	}
	}
	
		
		}
		
		
		
		public void keyTyped(KeyEvent e){}
			
		
		public void keyReleased(KeyEvent e){}
		
		
		
		
		
		
		
		
		
		
		
		public void ajoutercible(int hauteur, int debut_x){
			collectioncibles.add(new cible2("./avion1.png",hauteur,debut_x));
		}
			

	
	
	public boolean touche_cible(cible2 conteneurcible){
		
	
		if(this.conteneurballe!= null && conteneurcible != null){
	if((this.conteneurballe.get_centre_x() > conteneurcible.get_x_limite_gauche_de_limage()) &&
			 (this.conteneurballe.get_centre_x() < conteneurcible.get_x_limite_droite_de_limage())&&
			( this.conteneurballe.get_centre_z() > conteneurcible.get_z_limite_haut_de_limage() )&&
			 (this.conteneurballe.get_centre_z() < conteneurcible.get_z_limite_basse_de_limage())){
		
			return true; 
			}else
			{return false;}
		}
	
	return false;
}



}
	
	
	

	


		
		
		
		
		
		
	
	
	
	
	
	
	
		
