import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;					
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
	private JPanel p;
	private canon conteneur;
	private balle conteneurballe;
	private fond conteneurfond;
	private ArrayList<cible> collectioncibles;
	private long starttime;
	private long temps;
	private int decompte=18000;
	private FinDuJeu fin;
	public int k=0;
	
	//Constructeur
	public interfacegraphique(){
		i=0;
		//definition de la fenetre
		this.setTitle(" A vos Tirs!");
		this.setLayout(null);
		this.setSize(1300,700);
		this.setLocation(30,30);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ajout du timer qui va venir declencher le actionPerformed toutes les 5 millisecondes
		t = new Timer(5,this);
		t.start();													
		addKeyListener(this);
		// Création d'une ArrayList de cibles
		collectioncibles = new ArrayList<cible>();
		this.ajoutercible(200,3300,1);
		this.ajoutercible(100,3500,1);
		this.ajoutercible(300,4000,2);
		
		//les conteneurs canon et cibles font office de calque que l'on met dans le conteneur principal
		//definition du canon
		conteneur = new canon(40);
		conteneur.setLayout(null);
		conteneur.setBounds(0,0,1300,700);
		//definition de la balle
		conteneurballe=new balle(conteneur);
		conteneurballe.setLayout(null);
		conteneurballe.setBounds(0,0,1300,700);
		//ajout de l'image de fond
		conteneurfond = new fond();
		conteneurfond.setLayout(null);
		conteneurfond.setBounds(0,0,1300,700); 
		//definition du conteneur principal
		p = new JPanel();
		p.setLayout(null);
		this.setContentPane(p);
		p.setBounds(100,100,this.getWidth(),this.getHeight());
		p.add(conteneur);
		// Boucle for each : crée un conteneur pour chaque cible contenue dans l'ArrayList collectioncibles
		for(cible conteneurcible: collectioncibles){
			conteneurcible.setLayout(null);
			conteneurcible.setBounds(0,0,1300,700);
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
	// Méthode keyPressed
	public void keyPressed(KeyEvent e){ 
	     	repaint();
	}
		
	/** 
	 * Fait disparaître la balle quand une cible est touchée; affichage du décompte et de la fenêtre de fin du jeu quand le décompte est fini
	 * @param e un événement quelconque déclenché
	*/
	public void actionPerformed(ActionEvent e){
		for(cible conteneurcible : collectioncibles){	
			if(this.touche_cible(conteneurcible)==true && this.conteneurballe.getboolean_s()== false ){
				conteneurcible.setVisible(false);
				this.conteneurballe.setVisible(false);
				this.conteneurballe.setboolean_s(true);
				k=k+1;
				repaint();
			}
		}
		//Affichage du decompte
		if(this.isVisible()){
			this.setTitle(((decompte)*5/1000)+"       A vos Tirs!");
			repaint();
			decompte = decompte -1;
			// Affichage de la fenêtre de fin du jeu
			if((decompte==0) ){
				fin=new FinDuJeu(k);
				revalidate();
				validate();
				this.setVisible(false);
				fin.setVisible(true);
			}
		}
	}
	// Méthode keyTyped	
	public void keyTyped(KeyEvent e){}
	// Méthode keyRealesed	
	public void keyReleased(KeyEvent e){}
	
	/** 
	 * ajoute une nouvelle cible
	 * @param hauteur position y
	 * @param debut_x position x
	*/
	public void ajoutercible(int hauteur, int debut_x, int delt){
		collectioncibles.add(new cible("./avion1.png",hauteur,debut_x,delt));
	}
	
	/**
	 * Permet de savoir si une cible a été touchée par une balle
	 * @param conteneurcible une cible
	 * @return vrai si un avion a été touché et false sinon
	*/
	public boolean touche_cible(cible conteneurcible){
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
	
	
	

	


		
		
		
		
		
		
	
	
	
	
	
	
	
		
