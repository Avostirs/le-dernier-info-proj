import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.Color;

public class FinDuJeu extends JFrame{
	
	protected JButton monbouton;
	protected JLabel texte;
	protected JLabel texte2;
	private int p;

		
	public FinDuJeu(int k){
		setSize(800,530);
		setLocation(300,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		setTitle("fin");
		this.p=k;
	
		
		   
		
		    
		   
		    //zone de texte 
			texte=new JLabel("Nombres de tirs : "+this.p+" !!");
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
		
	
		revalidate();
		validate();
		
}	

public void setp(int k){
	this.p = k;
	
}
public int getp(){
	return this.p;
}

}
	
