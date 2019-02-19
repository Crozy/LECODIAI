package application;

import classes.Position;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Box;

public class Algo {

	private Tool outils;
	private int tour;
	private Position positionAspi = new Position(0, 0);

	public Algo(AnchorPane panel, Box aspi) {
		outils = new Tool(panel.getChildren().listIterator());
	}

	public void Parti(Box aspi) {
		System.out.println("Tour : " + tour);
//		if (positionAspi.x == aspi.getLayoutX() && positionAspi.y == aspi.getLayoutY()) {
		tour++;
//			if (tour > 50) {
//				outils.haut(aspi);
//				positionAspi.x = aspi.getLayoutX();
//				positionAspi.y = aspi.getLayoutY();
//			}
//		} else {
//			outils.avance(aspi);
//			positionAspi.x = aspi.getLayoutX();
//			positionAspi.y = aspi.getLayoutY();
//		}

		System.out.println("Radar : " + outils.recherche(aspi, "avance"));
		outils.recule(aspi);
	}

}
