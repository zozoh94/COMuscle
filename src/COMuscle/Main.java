package COMuscle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static int temps = 0;

	public static void main(String[] args) {
    	
		// Config
		boolean continuer = true;
		
		// CrÃ©ation du rÃ©seau routier
		File file1 = new File(0); // file sens 0 = va vers extremite1
		File file2 = new File(1); // file sens 1 = va vers extremite2
		
		Segment segment1 = new Segment(5, true); // true = crÃ©e automatiquement 2 nouvelles extrÃ©mitÃ©s
				segment1.setFiles(new ArrayList<File>(Arrays.asList(file1, file2))); // On oublit pas d'ajouter les files
		Segment segment2 = new Segment(7, true); // Segment de taille 7 unitÃ©s
				segment2.setFiles(new ArrayList<File>(Arrays.asList(file1, file2))); // Partage les mÃªmes files que segment1
		
		JonctionSimple jonction1 = new JonctionSimple(segment1, segment2); // Jonction va se lier Ã  segment1.extremit2 et segment2.extremite1 par dÃ©faut, si besoin d'autres extremitÃ©s il faut les spÃ©cifier explicitement
				// /!\ on ajoute pas de files ici car elles sont automatiquement ajoutÃ©es en rÃ©cupÃ©rant les infos de segment1 et segment2 (voir constructeur de Segment)
					   
		// Ajout de sémaphores ici et là
		PanneauSTOP semaphore1 = new PanneauSTOP(segment1.getExtremite2());
		FeuBicolore semaphore2 = new FeuBicolore(segment2.getExtremite2(), EnumFeu.ROUGE);
		
		// CrÃ©ation d'une voiture
		Voiture voiture1 = new Voiture(new Position(segment1, 0,file2));
		voiture1.setVitesse(1);
		
		//Creation d'un element de Regulation
		CVitesse cv = new CVitesse(new Position(segment1, 3,file2));
		RegulateurFeuRougeSiVitesseElevee r = new RegulateurFeuRougeSiVitesseElevee(semaphore2,cv);
		
		
		
		
		// CrÃ©ation de la boucle temporelle
		while (continuer) {
      
			System.out.println("\n-- Temps " + Main.temps);

			System.out.println(voiture1);
			voiture1.deplacer();
			r.run();
			continuer();
      
			Main.temps++;
		}
    	
	}
	
	public static void continuer(){
		System.out.println("Appuyer sur \"entrÃ©e\" pour continuer...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
}