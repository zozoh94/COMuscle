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
		
		Segment segment1 = new Segment(10, true); // true = crÃ©e automatiquement 2 nouvelles extrÃ©mitÃ©s
				segment1.setFiles(new ArrayList<File>(Arrays.asList(file1, file2))); // On oublit pas d'ajouter les files
		
		Segment segment2 = new Segment(10, true); // Segment de taille 7 unitÃ©s
				segment2.setFiles(new ArrayList<File>(Arrays.asList(file1, file2))); // Partage les mÃªmes files que segment1
		
		Segment segment3 = new Segment(10, true); // true = crÃ©e automatiquement 2 nouvelles extrÃ©mitÃ©s
				segment3.setFiles(new ArrayList<File>(Arrays.asList(file1, file2)));
				
		Segment segment4 = new Segment(10, true); // true = crÃ©e automatiquement 2 nouvelles extrÃ©mitÃ©s
				segment4.setFiles(new ArrayList<File>(Arrays.asList(file1, file2)));
				
		//JonctionSimple jonction1 = new JonctionSimple(segment1, segment2); // Jonction va se lier Ã  segment1.extremit2 et segment2.extremite1 par dÃ©faut, si besoin d'autres extremitÃ©s il faut les spÃ©cifier explicitement
				// /!\ on ajoute pas de files ici car elles sont automatiquement ajoutÃ©es en rÃ©cupÃ©rant les infos de segment1 et segment2 (voir constructeur de Segment)
		
		//Creation d'un Carrefour connectant 4 segments de route
		ArrayList<Extremite> e = new ArrayList<Extremite>();
		e.add(segment1.getExtremite2());
		e.add(segment2.getExtremite2());
		e.add(segment3.getExtremite2());
		e.add(segment4.getExtremite2());
		
		Carrefour carrefour = new Carrefour(e);
		
		
		// Ajout de sémaphores ici et là
		PanneauSTOP semaphore1 = new PanneauSTOP(segment1.getExtremite2());
		FeuBicolore semaphore2 = new FeuBicolore(segment2.getExtremite2(), EnumFeu.ROUGE);
		FeuTricolore semaphore3 = new FeuTricolore(segment3.getExtremite2(),EnumFeu.ORANGE);
		FeuTricolore semaphore4 = new FeuTricolore(segment4.getExtremite2(), EnumFeu.VERT);
		
		// Création de voitures ici et là
		Voiture voiture1 = new Voiture(new Position(segment1, 0,file2));
		voiture1.setVitesse(1);
		
		Voiture voiture2 = new Voiture(new Position(segment2, 0,file2));
		voiture2.setVitesse(1);
		
		Voiture voiture3 = new Voiture(new Position(segment3, 0,file2));
		voiture3.setVitesse(1);
		
		Voiture voiture4 = new Voiture(new Position(segment4, 0,file2));
		voiture4.setVitesse(1);
		
		
		
		
		//Creation d'un element de Regulation
		CVitesse cv1 = new CVitesse(new Position(segment1, 3,file2));
		RegulateurFeuRougeSiVitesseElevee r1 = new RegulateurFeuRougeSiVitesseElevee(semaphore2,cv1);
		
		CVitesse cv2 = new CVitesse(new Position(segment2, 3,file2));
		RegulateurFeuRougeSiVitesseElevee r2 = new RegulateurFeuRougeSiVitesseElevee(semaphore3,cv2);
		
		CVitesse cv3 = new CVitesse(new Position(segment3, 3,file2));
		RegulateurFeuRougeSiVitesseElevee r3 = new RegulateurFeuRougeSiVitesseElevee(semaphore4,cv3);
		
		
		
		
		
		// CrÃ©ation de la boucle temporelle
		while (continuer) {
      
			System.out.println("\n-- Temps " + Main.temps);

			System.out.println(voiture1);
			voiture1.deplacer();
			
			System.out.println(voiture2);
			voiture2.deplacer();
			
			System.out.println(voiture3);
			voiture3.deplacer();
			
			System.out.println(voiture4);
			voiture4.deplacer();
			
			
			r1.run();
			r2.run();
			r3.run();
			
			
			
			continuer();
      
			Main.temps++;
			
			
		}
    	
	}
	
	public static void continuer() {
		System.out.println("Appuyer sur \"entrée\" pour continuer...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
}
}