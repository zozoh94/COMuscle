package COMuscle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static int temps=0;
	public static void main(String[] args) {
    	
		// Config
		
		boolean continuer = true;
		
		// Création du réseau routier
		File file1 = new File(0); // file sens 0 = va vers extremite1
		File file2 = new File(1); // file sens 1 = va vers extremite2
		
		Segment segment1 = new Segment(5, true); // true = crée automatiquement 2 nouvelles extrémités
				segment1.setFiles(new ArrayList<File>(Arrays.asList(file1, file2))); // On oublit pas d'ajouter les files
		Segment segment2 = new Segment(7, true); // Segment de taille 7 unités
				segment2.setFiles(new ArrayList<File>(Arrays.asList(file1, file2))); // Partage les mêmes files que segment1
		
		JonctionSimple jonction1 = new JonctionSimple(segment1, segment2); // Jonction va se lier à segment1.extremit2 et segment2.extremite1 par défaut, si besoin d'autres extremités il faut les spécifier explicitement
				// /!\ on ajoute pas de files ici car elles sont automatiquement ajoutées en récupérant les infos de segment1 et segment2 (voir constructeur de Segment)
					   
		// Ajout de sémaphores ici et là
		PanneauSTOP semaphore1 = new PanneauSTOP(segment2.getExtremite1());
		FeuTricolore semaphore2 = new FeuTricolore(segment2.getExtremite1());
		
		// Création d'une voiture
		Voiture voiture1 = new Voiture(new Position(segment1, 0,file2));
		voiture1.setVitesse(1);
		
		//Creation d'un element de Regulation
		CVitesse cv = new CVitesse(new Position(segment1, 3,file2));
		RegulateurFeuRougeSiVitesseElevee r = new RegulateurFeuRougeSiVitesseElevee(semaphore2,cv);
		
		
		
		
		// Création de la boucle temporelle
		while (continuer) {
			System.out.println("\n-- Temps " + temps);
			System.out.println("le feu est " + semaphore2);
			//System.out.println("la position du capteur : " + cv.saPosition.getPosition());
			
			
			
			System.out.println(voiture1);
			voiture1.deplacer();
			
			//r.run();
			System.out.println("le feu est " + semaphore2);
			//System.out.println("pos vehicule : " + voiture1.getPosition().getPosition());
			continuer();
			
			temps++;
			semaphore2.periodiqueColorChange();
			
		}
    	
	}
	
	public static void continuer(){
		System.out.println("Appuyer sur \"entrée\" pour continuer...");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
	}
	
	
}