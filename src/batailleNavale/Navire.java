package batailleNavale;

import java.util.Random;

/**
 * 
 * @author Weiss & Dulhoste
 * @version 1
 *
 */
public class Navire{
	
	int [] bateau = new int[17];
	
	public Navire(){
		
		boolean estVertical = false;
		double choix = Math.random();
		Random rand = new Random();
		int nombreAleatoire = rand.nextInt(100);
		int tailletableau = 0;
		int nbrcaseremplie = 0;
		
		//on met le bateau de 5 case
		if(choix < 0.5){
			estVertical = true;
		}
		else{
			estVertical = false;
		}
		if(estVertical){
			while(nombreAleatoire>60){
				rand = new Random();
				nombreAleatoire = rand.nextInt(100);
			}
			tailletableau = 0;
			for(int i=0; i<5; i++)
			{
				bateau[nbrcaseremplie+i] = nombreAleatoire + tailletableau;
				tailletableau += 10;
			}
		}
		else{
			while(nombreAleatoire%10>5){
				rand = new Random();
				nombreAleatoire = rand.nextInt(100);
			}
			tailletableau = 0;
			for(int i=0; i<5; i++)
			{
				bateau[nbrcaseremplie+i] = nombreAleatoire + tailletableau;
				tailletableau += 1;
			}
		}
		
		nbrcaseremplie += 5;
		//on met le bateau de 4 cases
		choix = Math.random();
		if(choix < 0.5){
			estVertical = true;
		}
		else{
			estVertical = false;
		}
		rand = new Random();
		nombreAleatoire = rand.nextInt(100);
		if(estVertical){
			while(nombreAleatoire>70 || contientBateau(nombreAleatoire)==true || contientBateau(nombreAleatoire+10)==true || contientBateau(nombreAleatoire+20)==true || contientBateau(nombreAleatoire+30)==true){
				rand = new Random();
				nombreAleatoire = rand.nextInt(100);
			}
			tailletableau = 0;
			for(int i=0; i<4; i++)
			{
				bateau[nbrcaseremplie+i] = nombreAleatoire + tailletableau;
				tailletableau += 10;
			}
		}
		else{
			while(nombreAleatoire%10>6 || contientBateau(nombreAleatoire)==true || contientBateau(nombreAleatoire+1)==true || contientBateau(nombreAleatoire+2)==true || contientBateau(nombreAleatoire+3)==true){
				rand = new Random();
				nombreAleatoire = rand.nextInt(100);
			}
			tailletableau = 0;
			for(int i=0; i<4; i++)
			{
				bateau[nbrcaseremplie+i] = nombreAleatoire + tailletableau;
				tailletableau += 1;
			}
		}
		
		nbrcaseremplie += 4;
		//on met les 2 bateaux de 3 cases
			for(int j = 0; j<2;j++){
				choix = Math.random();
				if(choix < 0.5){
					estVertical = true;
				}
				else{
					estVertical = false;
				}
				rand = new Random();
				nombreAleatoire = rand.nextInt(100);
				if(estVertical){
					while(nombreAleatoire>80 || contientBateau(nombreAleatoire)==true || contientBateau(nombreAleatoire+20)==true || contientBateau(nombreAleatoire+10)==true)
					{
						rand = new Random();
						nombreAleatoire = rand.nextInt(100);
					}
					tailletableau = 0;
					for(int i=0; i<3; i++)
					{
						bateau[nbrcaseremplie+i] = nombreAleatoire + tailletableau;
						tailletableau += 10;
					}
				}
				else{
					while(nombreAleatoire%10>7 || contientBateau(nombreAleatoire)==true || contientBateau(nombreAleatoire+1)==true || contientBateau(nombreAleatoire+2)==true){
						rand = new Random();
						nombreAleatoire = rand.nextInt(100);
					}
					tailletableau = 0;
					for(int i=0; i<3; i++)
					{
						bateau[nbrcaseremplie+i] = nombreAleatoire + tailletableau;
						tailletableau += 1;
					}
				}
				nbrcaseremplie+=3;
			}
		
			//on met le bateau de 2 cases
			
			choix = Math.random();
			if(choix < 0.5){
				estVertical = true;
			}
			else{
				estVertical = false;
			}
			rand = new Random();
			nombreAleatoire = rand.nextInt(100);
			if(estVertical){
				while(nombreAleatoire>90 || contientBateau(nombreAleatoire)==true || contientBateau(nombreAleatoire+10)==true){
					rand = new Random();
					nombreAleatoire = rand.nextInt(100);
				}
				tailletableau = 0;
				for(int i=0; i<2; i++)
				{
					bateau[nbrcaseremplie+i] = nombreAleatoire + tailletableau;
					tailletableau += 10;
				}
			}
			else{
				while(nombreAleatoire%10>8 || contientBateau(nombreAleatoire)==true || contientBateau(nombreAleatoire+1)==true){
					rand = new Random();
					nombreAleatoire = rand.nextInt(100);
				}
				tailletableau = 0;
				for(int i=0; i<2; i++)
				{
					bateau[nbrcaseremplie+i] = nombreAleatoire + tailletableau;
					tailletableau += 1;
				}
			}
	}

	public boolean contientBateau(int numerobouton) {
		for(int j = 0; j < 17; j++){
			if(numerobouton == getValeur(j))
			{
				return true;
			}
		}
		return false;
	}
	
	public int getValeur(int position){
		return bateau[position];
	}
	
	
}
