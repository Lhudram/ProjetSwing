package batailleNavale;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * 
 * @author Weiss & Dulhoste
 * @version 1
 *
 */
public class Selection extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JLabel jl_titrehaut = new JLabel ("Bataille Navale");
	JLabel jl_joueur1 = new JLabel ("Joueur 1 :");
	JLabel jl_joueur2 = new JLabel ("Joueur 2 :");
	JLabel jl_ajoutespace = new JLabel (" ");
	JLabel jl_ajoutespace2 = new JLabel (" ");
	
	static JTextField jt_NomJoueur1 = new JTextField(30);
	static JTextField jt_NomJoueur2 = new JTextField(30);
	
	JButton jb_Jouer = new JButton ("Jouez!");
	//La fonction "joueur contre ia" n'est pas intégrée
	JRadioButton jrb_ordi = new JRadioButton("Ordinateur");
	JRadioButton jrb_realplayer = new JRadioButton("Joueur");
	
	JLabel jl_erreur = new JLabel ("");
	
	public static String Pseudo1 = new String("");
	public static String Pseudo2 = new String("");
	
	/**
	 * Constructeur de la fenêtre de selection
	 */
	public Selection(){
		super();
		JFrame fenselect = new JFrame();
		JPanel jpcentre = new JPanel();
		
		//Déclaration des layouts
		BorderLayout main = new BorderLayout(40,40);
		GridLayout center = new GridLayout(3, 2);
		
		//ajout des éléments sur le premier layout
		fenselect.getContentPane().setLayout(main);
		fenselect.getContentPane().add(jl_titrehaut, BorderLayout.NORTH);
		this.jl_titrehaut.setHorizontalAlignment(SwingConstants.CENTER);
		fenselect.getContentPane().add(jb_Jouer, BorderLayout.EAST);
		fenselect.getContentPane().add(jl_ajoutespace, BorderLayout.SOUTH);
		fenselect.getContentPane().add(jl_ajoutespace2, BorderLayout.WEST);
		fenselect.getContentPane().add(jl_erreur, BorderLayout.SOUTH);
		this.jl_erreur.setHorizontalAlignment(SwingConstants.CENTER);
		
		//ajout du groupe de radio boutons
	    ButtonGroup bg = new ButtonGroup();
	    bg.add(jrb_ordi);
	    bg.add(jrb_realplayer);
	    
	    //ajout des éléments sur le second layout
		jpcentre.setLayout(center);
		jpcentre.add(jl_joueur1);
		jpcentre.add(jt_NomJoueur1);
		jpcentre.add(jrb_ordi);
		jpcentre.add(jrb_realplayer);
		
		//ajout d'action listeners sur les radio boutons
	    jrb_ordi.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    	    jt_NomJoueur2.setText("Ordinateur");
	    	}
	    });
	    jrb_realplayer.addActionListener(new ActionListener(){
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    	    jt_NomJoueur2.setText("");
	    	}
	    });
	    
	    jb_Jouer.addActionListener(new ActionListener(){
	    	
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		//Vérification qu'un login est entré
	    		if (jt_NomJoueur2.getText().equals("") || jt_NomJoueur1.getText().equals("")){
	    			jl_erreur.setText("<html><font color = #98252C >La saisie d'un login est obligatoire</font></html>");
	    		}else{
	    			//Si les login sont rentrés, le jeu se lance
	    			fenselect.dispose();
	    			Plateau plateau1 = new Plateau();
	    		}
	    	}
	    });
	    
		jpcentre.add(jl_joueur2);
		jpcentre.add(jt_NomJoueur2);
		fenselect.getContentPane().add(jpcentre, BorderLayout.CENTER);
		
		fenselect.setSize(600, 400);
		fenselect.setTitle("Ecran de selection");
		fenselect.setDefaultCloseOperation(EXIT_ON_CLOSE);
		fenselect.setVisible(true);
		fenselect.setResizable(false);
	}
	
	/**
	 * Méthode qui récupère le nom du premier joueur
	 * @return Pseudo1
	 */
	public static String getPseudo1(){
		Pseudo1 = jt_NomJoueur1.getText();
		return Pseudo1;
	}
	
	/**
	 * Méthode qui récupère le nom du second joueur
	 * @return Pseudo2
	 */
	public static String getPseudo2(){
		Pseudo2 = jt_NomJoueur2.getText();
		return Pseudo2;
	}
}
