package batailleNavale;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author Weiss & Dulhoste
 * @version 2
 *
 */
public class Plateau extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel jp_info = new JPanel();
	JPanel jp_grille = new JPanel();
	JPanel jp_grille2 = new JPanel();
	JPanel jp_grilles = new JPanel();
	JButton jb_rejouer = new JButton("Nouvelle Partie");
	JPanel jp_pseudo = new JPanel();
	
	JLabel jl_espace = new JLabel(" ");
	JLabel jl_espace2 = new JLabel(" ");
	
	JLabel jl_score1 = new JLabel("0");
	JLabel jl_score2 = new JLabel("0");
	JLabel Pseudo1 = new JLabel(Selection.getPseudo1());
	JLabel Pseudo2 = new JLabel(Selection.getPseudo2());
	JLabel Player1 = new JLabel(Selection.getPseudo1());
	JLabel Player2 = new JLabel(Selection.getPseudo2());
	JLabel jl_commentaire = new JLabel("");
	
	int numerobouton;

	int [] CoupPrecedentJ1 = new int[1000];
	int [] CoupPrecedentJ2 = new int[1000];
	int NombreCoup = 0;
	int NombreCoupJ2 = 0;
	static Navire navire = new Navire();
	static Navire navire2 = new Navire();
	int NbrCaseTouchée = 0;
	int NbrCaseTouchéeJ2 = 0;
	
	/**
	 * Constructeur du plateau de jeu
	 */
	public Plateau(){
		super();
		JFrame fenplateau = new JFrame();
		BorderLayout main = new BorderLayout(100, 10);
		GridLayout info = new GridLayout(6, 1);
		GridLayout grille = new GridLayout(10, 10);
		GridLayout grilles = new GridLayout(1, 2);
		GridLayout pseudos = new GridLayout(1, 2);
		Border blackline = BorderFactory.createLineBorder(Color.black, 1);
		
		//on remplit tableau avec 101, car de base le tableau est rempli de 0, ce qui pose un problème avec la case 0
		for(int i = 0; i<1000; i++){
			CoupPrecedentJ1[i] = 101;
			CoupPrecedentJ2[i] = 101;
		}
		
		for(int i = 0; i<100; i++){
			//Affichage de la grille
			JButton jbGrille = new JButton("");
			jbGrille.setBackground(Color.white);
			jp_grille.add(jbGrille);
			
			final int numero = i;
			jbGrille.addActionListener(new ActionListener(){
		    	
		    	@Override
		    	public void actionPerformed(ActionEvent e) {
			    	if(NbrCaseTouchée < 17){
			    		if(!dejaCliquéJ1(numero)){
			    			if(estTouchéeJ1(numero)){
					    		jbGrille.setBackground(Color.GREEN);
					    		jl_commentaire.setText("<html><font color = #85C17E >Touché !</font></html>");
					    		//TODO
					    		sound player = new sound("Touche.wav");
								InputStream stream = new ByteArrayInputStream(player.getSamples());
								player.play(stream);
								NbrCaseTouchée += 1;
					    	}
			    			else{
					    		jbGrille.setBackground(Color.RED);
					    		jl_commentaire.setText("<html><font color = #98252C >Dans l'eau !</font></html>");
					    		sound player = new sound("plouf.wav");
								InputStream stream = new ByteArrayInputStream(player.getSamples());
								player.play(stream);
				    		}
				    	}
			    		else{
				    		jl_commentaire.setText("Deja cliqué!");
			    		}
			    		jp_grille.setVisible(false);
			    		jp_grille2.setVisible(true);
			    	}
			    	else{
			    		sound player = new sound("Victoire.wav");
						InputStream stream = new ByteArrayInputStream(player.getSamples());
						player.play(stream);
						jl_commentaire.setText("Bravo!");
						try {
							TimeUnit.SECONDS.sleep(5);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						fenplateau.dispose();
			    		Selection selection = new Selection();
			    		Navire navire = new Navire();
			    	}
		    }});
		}
		for(int i = 0; i<100; i++){
			//Affichage de la grille
			JButton jbGrille = new JButton("");
			jbGrille.setBackground(Color.white);
			jp_grille2.add(jbGrille);
			
			final int numeroJ2 = i;
			jbGrille.addActionListener(new ActionListener(){
		    	
		    	@Override
		    	public void actionPerformed(ActionEvent e) {
			    	if(NbrCaseTouchéeJ2 < 17){
			    		if(!dejaCliquéJ2(numeroJ2)){
			    			if(estTouchéeJ2(numeroJ2)){
					    		jbGrille.setBackground(Color.GREEN);
					    		jl_commentaire.setText("<html><font color = #85C17E >Touché !</font></html>");
					    		//TODO
					    		sound player = new sound("Touche.wav");
								InputStream stream = new ByteArrayInputStream(player.getSamples());
								player.play(stream);
								NbrCaseTouchéeJ2 += 1;
					    			}
			    			else{
					    		jbGrille.setBackground(Color.RED);
					    		jl_commentaire.setText("<html><font color = #98252C >Dans l'eau !</font></html>");
					    		sound player = new sound("plouf.wav");
								InputStream stream = new ByteArrayInputStream(player.getSamples());
								player.play(stream);
				    		}
				    	}
			    		else{
				    		jl_commentaire.setText("Deja cliqué!");
			    		}
			    		jp_grille2.setVisible(false);
			    		jp_grille.setVisible(true);
			    	}
			    	else{
			    		sound player = new sound("Victoire.wav");
						InputStream stream = new ByteArrayInputStream(player.getSamples());
						player.play(stream);
						jl_commentaire.setText("Bravo!");
						try {
							TimeUnit.SECONDS.sleep(5);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						fenplateau.dispose();
			    		Selection selection = new Selection();
			    		Navire navire = new Navire();
			    	}
		    }});
		}
	
		fenplateau.getContentPane().setLayout(main);
		this.jp_info.setLayout(info);
		this.jp_grille.setLayout(grille);
		this.jp_grille2.setLayout(grille);
		this.jp_grilles.setLayout(grilles);
		this.jp_grilles.add(this.jp_grille);
		this.jp_grilles.add(this.jp_grille2);
		jp_grille2.setVisible(false);
		
		this.jp_pseudo.setLayout(pseudos);
		this.jp_pseudo.add(jl_espace2);
		this.jp_pseudo.add(Pseudo1);
		this.jp_pseudo.add(Pseudo2);
		
		this.jp_info.add(Player1);
		this.jp_info.add(jl_score1);
		this.jp_info.add(Player2);
		this.jp_info.add(jl_score2);
		this.jp_info.add(jl_commentaire);
		this.jp_info.add(this.jb_rejouer);
		this.jp_info.setBorder(new EmptyBorder(0,20,20,0));
		
		fenplateau.getContentPane().add(this.jp_grilles , BorderLayout.CENTER);
		fenplateau.getContentPane().add(this.jp_info, BorderLayout.WEST);
		fenplateau.getContentPane().add(this.jp_pseudo, BorderLayout.NORTH);
		fenplateau.getContentPane().add(this.jl_espace, BorderLayout.SOUTH);
		
		this.jb_rejouer.addActionListener(new ActionListener(){
	    	
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		fenplateau.dispose();
	    		Selection selection = new Selection();
	    		Navire navire = new Navire();
	    	}
	    });

		fenplateau.setSize(930, 420);
		fenplateau.setTitle("Plateau");
		fenplateau.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fenplateau.setVisible(true);
		fenplateau.setResizable(false);
		
	}
	
	public boolean estTouchéeJ1(int numcase){
		if(NombreCoup < 1000){
			
    		//Gestion du nombre de coups
    		CoupPrecedentJ1[NombreCoup] = numcase;
    		NombreCoup = NombreCoup + 1;
    		
    		if(navire.contientBateau(numcase)){
    			return true;
    		}
    		else{
    			return false;
    		}
		}
		return false;	
	}
	
	public boolean estTouchéeJ2(int numcase){
		if(NombreCoup < 1000){
			
    		//Gestion du nombre de coups
    		CoupPrecedentJ2[NombreCoupJ2] = numcase;
    		NombreCoupJ2 = NombreCoupJ2 + 1;
    		
    		if(navire2.contientBateau(numcase)){
    			return true;
    		}
    		else{
    			return false;
    		}
		}
		return false;	
	}
	
	public boolean dejaCliquéJ1(int numcase){
		
		for(int i=0; i<17; i++)
		{
			if(CoupPrecedentJ1[i] == numcase){
				return true;
			}
		}
		return false;
	}
public boolean dejaCliquéJ2(int numcase){
		
		for(int i=0; i<17; i++)
		{
			if(CoupPrecedentJ2[i] == numcase){
				return true;
			}
		}
		return false;
	}
}

