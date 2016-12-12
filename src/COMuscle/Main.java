package COMuscle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int temps = 0;

	public static void main(String[] args) {
    	
		// Config
		boolean continuer = true;
		
		// Cr�ation du r�seau routier
		File file1 = new File(0); // file sens 0 = va vers extremite1
		File file2 = new File(1); // file sens 1 = va vers extremite2
		
		Segment segment1 = new Segment(50, true); // true = cr�e automatiquement 2 nouvelles extr�mit�es
				segment1.setFiles(new ArrayList<File>(Arrays.asList(file1, file2))); // On oublit pas d'ajouter les files
		Segment segment2 = new Segment(70, true); // Segment de taille 7 unités
				segment2.setFiles(new ArrayList<File>(Arrays.asList(file1, file2))); // Partage les m�mes files que segment1
		
		JonctionSimple jonction1 = new JonctionSimple(segment1, segment2); // Jonction va se lier � segment1.extremit2 et segment2.extremite1 par d�faut, si besoin d'autres extremit�es il faut les sp�cifier explicitement
				// /!\ on ajoute pas de files ici car elles sont automatiquement ajout�es en r�cup�rant les infos de segment1 et segment2 (voir constructeur de Segment)
					   
		// Ajout de s�maphores ici et l�
		PanneauSTOP semaphore1 = new PanneauSTOP(segment1.getExtremite2());
		FeuTricolore semaphore2 = new FeuTricolore(segment2.getExtremite2(), EnumFeu.ORANGE);
		
		// Cr�ation d'une voiture
		Voiture voiture1 = new Voiture(new Position(segment1, 0,file2));
		voiture1.setVitesse(10);
		
		//Cr�ation d'un element de Regulation
		CVitesse cv = new CVitesse(new Position(segment1, 3,file2));
		RegulateurFeuRougeSiVitesseElevee r = new RegulateurFeuRougeSiVitesseElevee(semaphore2,cv);
		
		
		
		
		// Cr�ation de la boucle temporelle
		while (continuer) {
      
			System.out.println("\n-- Temps " + Main.temps);
			
			System.out.println(voiture1);
			try {
				voiture1.deplacer();
			} catch (DemiTourImpossibleException e) {
				e.printStackTrace();
			}
			r.run();
			continuer();
			
			Main.temps++;
		}
    	
	}
	
	public static void continuer(){
		System.out.println("Appuyer sur \"entr�e\" pour continuer...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
}