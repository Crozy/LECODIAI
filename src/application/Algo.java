package application;

import java.util.Random;

import classes.Position;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Box;

public class Algo {

	private Tool outils;
	private int tour;
	private int valeurAlea = 1; // 1: avance, 2: recule, 3: haut, 4: bas
	private String action = "";
	private Random aleatoire = new Random();

	public Algo(AnchorPane panel, Box aspi) {
		outils = new Tool(panel.getChildren().listIterator());
		valeurAlea = 1 + aleatoire.nextInt(4);

		System.out.println(valeurAlea);

		switch (valeurAlea) {
		case 1:
			action = "avance";
			break;
		case 2:
			action = "recule";
			break;
		case 3:
			action = "haut";
			break;
		case 4:
			action = "bas";
			break;
		default:
			break;
		}

	}

	public void Parti(Box aspi) {
		System.out.println("Tour : " + tour);
		tour++;
		if (tour == 100) {
			tour = 0;
			valeurAlea = 1 + aleatoire.nextInt(4);
			switch (valeurAlea) {
			case 1:
				action = "avance";
				break;
			case 2:
				action = "recule";
				break;
			case 3:
				action = "haut";
				break;
			case 4:
				action = "bas";
				break;
			default:
				break;
			}
		} else {
			if (outils.recherche(aspi, action)) {
				switch (valeurAlea) {
				case 1:
					outils.avance(aspi);
					break;
				case 2:
					outils.recule(aspi);
					break;
				case 3:
					outils.haut(aspi);
					break;
				case 4:
					outils.bas(aspi);
					break;
				default:
					break;
				}
			} else {
				valeurAlea = 1 + aleatoire.nextInt(4);
				switch (valeurAlea) {
				case 1:
					action = "avance";
					break;
				case 2:
					action = "recule";
					break;
				case 3:
					action = "haut";
					break;
				case 4:
					action = "bas";
					break;
				default:
					break;
				}
			}
		}
		// outils.bas(aspi);
		System.out.println("Radar : " + outils.recherche(aspi, "avance"));
	}

}
