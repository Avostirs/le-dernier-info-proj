import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class interfacegraphique extends JFrame implements KeyListener,ActionListener {


		private Timer t;
		private int i;
		public JPanel p;
		public canon conteneur;
		public cible2 conteneurcible;
		public balle conteneurballe;
	
	public interfacegraphique(){
		
		i=0;
		
		//definition de la fenetre
		this.setTitle(" A vos Tirs!");
		this.setLayout(null);
		this.setSize(1300,700);
		this.setLocation(30,30);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//ajout du timer qui va venir declencher notre actionPerformed toutes les 5 millisecondes
		t = new Timer(1,this);
		t.start();													
		
		addKeyListener(this);
		
		
		
		
		
	//les conteneurs canon et cibles font office de calque que l'on met dur me conteneur principal
	
		// definition de la cible
		conteneurcible = new cible2();
		conteneurcible.setLayout(null);
		conteneurcible.setBounds(0,0,1300,600);
		
		//definition du canon
		conteneur = new canon(40);
		conteneur.setLayout(null);
		conteneur.setBounds(0,0,1300,600);
		
		//definition de la balle
		conteneurballe=new balle(conteneur);
		conteneurballe.setLayout(null);
		conteneurballe.setBounds(0,0,1300,600);
		
	
		//definition du conteneur principal
		p = new JPanel();
		p.setLayout(null);
		this.setContentPane(p);
		p.setBounds(100,100,this.getWidth(),this.getHeight());
		p.setBackground(Color.yellow);
		p.add(conteneur);
		p.add(conteneurcible);
		p.add(conteneurballe);
		this.addKeyListener(conteneurballe);
		this.addKeyListener(conteneur);
		p.revalidate();
		p.validate();
		validate();
		repaint();	
		
	}
	

		public void keyPressed(KeyEvent e){
	
		}
		
		public void actionPerformed(ActionEvent e){
		repaint();
		
		}
		
		public void keyTyped(KeyEvent e){}
			
		public void keyReleased(KeyEvent e){}
			
			
		//methode paint
		public void dessine(Graphics g){
			conteneur.paint(g);
			conteneurcible.paint(g);
			conteneurballe.paint(g);		
			}
	
	
	
	
}
	


		
		
		
		
		
		
	
	
	
	
	
	
	
		
