package application;

import classes.Position;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Box;

public class Algo {

	private Tool outils;
	private int tour;
	private Position positionAspi = new Position(0, 0);
	private String actionPrec = "recule";

	public Algo(AnchorPane panel, Box aspi) {
		outils = new Tool(panel.getChildren().listIterator());
	}

	public void Parti(Box aspi) {
		System.out.println("Tour : " + tour);
		tour++;

		if (outils.recherche(aspi, actionPrec)) {
			switch (actionPrec) {
			case "avance":
				outils.avance(aspi);
				break;
			case "recule":
				outils.recule(aspi);
				break;
			case "haut":
				outils.haut(aspi);
				break;
			case "bas":
				outils.bas(aspi);
				break;
			default:
				break;
			}
		} else {

			if (outils.recherche(aspi, "avance")) {
				outils.avance(aspi);
				actionPrec = "avance";
			} else {
				if (outils.recherche(aspi, "haut")) {
					outils.haut(aspi);
					actionPrec = "haut";
				} else {
					if (outils.recherche(aspi, "recule")) {
						outils.recule(aspi);
						actionPrec = "recule";
					} else {
						if (outils.recherche(aspi, "bas")) {
							outils.bas(aspi);
							actionPrec = "bas";
						}
					}
				}
			}
		}

		System.out.println("Radar : " + outils.recherche(aspi, "avance"));
	}

}
