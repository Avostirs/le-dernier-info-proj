import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.Color;

public class regles extends JFrame implements ActionListener{
	
	protected JButton monbouton;
	protected JLabel texte;
	protected JLabel texte2;
	protected interfacegraphique dessin;

		
	public regles(){
		setSize(800,530);
		setLocation(300,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		   
		
		//gestion du conteneur bleu
		    
		    //bouton
		    monbouton=new JButton(">Jouer");
		    monbouton.setBounds(550,370,100,30);
		    monbouton.setBackground(new Color(128,128,0));
		    monbouton.setForeground(new Color(0,0,0));
		    //ajout ecouteur
		    monbouton.addActionListener(this);
		    //zone de texte 
			texte=new JLabel("<html>Bienvenue ! Pour jouer, il vous suffit de regler l'angle de tir avec les touches du clavier W et S puis <br> d'appuyer sur la touche espace quelques secondes avec la duree de votre choix. Cela chargera la puissance de lancer de la balle. Vous avez 1m30s pour tirer le plus de fois sur le bonhomme. Attention, celui ci se deplace !! Etes vous prets ? A Vos Tirs...</html>");
			texte.setBounds(100,50,600,310);
			texte.setForeground(new Color(255,255,255));
			Font font=new Font("Stencil", Font.BOLD, 25);
			texte.setFont(font);
			//zone de texte2
			texte2=new JLabel("A Vos Tirs !");
			texte2.setBounds(280,25,600,40);
			texte2.setForeground(new Color(128,128,0));
			Font font2=new Font("Stencil", Font.BOLD, 30);
			texte2.setFont(font2);
			
		    
		    
		    
		//Affichage conteneur interieur
		JPanel interieur =new JPanel();  
		interieur.setBackground(new Color(200,173,127));
		interieur.setBounds(20,20,740,450);
		interieur.add(monbouton);
		interieur.add(texte);
		interieur.add(texte2);
		interieur.setLayout(null);
		    
		//Gestion du conteneur bord    
		JPanel bord=new JPanel();
		bord.setBackground(new Color(157,62,12));
		bord.setBounds(0,0,400,400);
		bord.add(interieur); 
		bord.setLayout(null); 
		this.setContentPane(bord); 
		
		//creation de l'interface
		dessin=new interfacegraphique();
		dessin.setVisible(false);
		revalidate();
		validate();
		
}	
public void actionPerformed(ActionEvent e){
	if (e.getSource() == monbouton){
		dessin.setVisible(true);
		this.setVisible(false);
	}}
	
}
		


	

