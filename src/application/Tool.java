package application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

import javax.naming.spi.DirStateFactory.Result;

import javafx.scene.Node;
import javafx.scene.shape.Box;
import javafx.scene.shape.Line;

public class Tool {

	private ListIterator<Node> listDesElements;
	private ArrayList<Line> listObstacle = new ArrayList<>();

	public Tool(ListIterator<Node> listElements) {
		this.listDesElements = listElements;
		while (listDesElements.hasNext()) {
			Node result = listDesElements.next();
			// System.out.println("ID : " + result.getId() + " Type : " +
			// result.getTypeSelector());
			if (result.getId() != null) {
				if (result.getTypeSelector().equals("Line") && result.getId().indexOf("mur") > -1) {
					Line obstacle = (Line) result;
					// System.out.println("Emplacement mur : " +
					// String.valueOf(obstacle.getStartX()));
					listObstacle.add(obstacle);
				}
			}
		}
	}

	public ListIterator<Node> getListElements() {
		return listDesElements;
	}

	public void avance(Box aspi) {
		if (recherche(aspi, "avance")) {
			aspi.setLayoutX(aspi.getLayoutX() + 1);
		}
	}

	public void recule(Box aspi) {
		if (recherche(aspi, "recule")) {
			aspi.setLayoutX(aspi.getLayoutX() - 1);
		}
	}

	public void haut(Box aspi) {
		if (recherche(aspi, "haut")) {
			aspi.setLayoutY(aspi.getLayoutY() - 1);
		}
	}

	public void bas(Box aspi) {
		if (recherche(aspi, "bas")) {
			aspi.setLayoutY(aspi.getLayoutY() + 1);
		}
	}

	public Boolean recherche(Box aspi, String action) {

		if (action.equals("avance")) {

			ArrayList<Line> listObstacleADroite = new ArrayList<>();

			// Recupere les Line situé a droite de l'aspi
			for (Line result : listObstacle) {
				if (result.getStartX() > aspi.getLayoutX()) {
					listObstacleADroite.add(result);
				}
			}

			for (Line mur : listObstacleADroite) {

				if (aspi.getLayoutY() >= mur.getStartY() && aspi.getLayoutY() <= mur.getEndY()) {

					if (aspi.getLayoutX() + aspi.getWidth() >= mur.getStartX()
							&& aspi.getLayoutX() - aspi.getWidth() <= mur.getEndX()) {
						System.out.println("Position X : " + mur.getStartX() + " mur : " + mur.getId());
						return false;
					}
				}
			}
		}

		if (action.equals("recule")) {

			ArrayList<Line> listObstacleAGauche = new ArrayList<>();

			// Recupere les Line situé a droite de l'aspi
			for (Line result : listObstacle) {
				if (result.getStartX() < aspi.getLayoutX()) {
					listObstacleAGauche.add(result);
				}
			}

			for (Line mur : listObstacleAGauche) {

				if (aspi.getLayoutY() >= mur.getStartY() && aspi.getLayoutY() <= mur.getEndY()) {

					if (aspi.getLayoutX() + aspi.getWidth() >= mur.getStartX()
							&& aspi.getLayoutX() - aspi.getWidth() <= mur.getEndX()) {
						System.out.println("Position X : " + mur.getStartX() + " mur : " + mur.getId());
						return false;
					}
				}
			}
		}

		if (action.equals("haut")) {

			ArrayList<Line> listObstacleAHaut = new ArrayList<>();

			// Recupere les Line situé a droite de l'aspi
			for (Line result : listObstacle) {
				if (result.getStartY() < aspi.getLayoutY()) {
					//System.out.println(" mur : " + result.getId());
					listObstacleAHaut.add(result);
				}
			}

			for (Line mur : listObstacleAHaut) {

//				if (aspi.getLayoutY() + aspi.getHeight() >= mur.getStartY()
//						&& aspi.getLayoutY() - aspi.getHeight() <= mur.getEndY()) {
				if (aspi.getLayoutY() + aspi.getHeight() >= mur.getEndY()
						&& aspi.getLayoutY() - aspi.getHeight() <= mur.getStartY()) {

					if (aspi.getLayoutX() + aspi.getWidth() >= mur.getStartX()
							&& aspi.getLayoutX() - aspi.getWidth() <= mur.getEndX()) {
						System.out.println("Position X : " + mur.getStartX() + " mur : " + mur.getId());
						return false;
					}
				}
			}
		}

		if (action.equals("bas")) {

			ArrayList<Line> listObstacleABas = new ArrayList<>();

			// Recupere les Line situé a droite de l'aspi
			for (Line result : listObstacle) {
				if (result.getStartY() > aspi.getLayoutY()) {
					//System.out.println(" mur : " + result.getId());
					listObstacleABas.add(result);
				}
			}

			for (Line mur : listObstacleABas) {

				if (aspi.getLayoutY() + aspi.getHeight() >= mur.getStartY()
						&& aspi.getLayoutY() - aspi.getHeight() <= mur.getEndY()) {

					if (aspi.getLayoutX() + aspi.getWidth() >= mur.getStartX()
							&& aspi.getLayoutX() - aspi.getWidth() <= mur.getEndX()) {
						System.out.println("Position X : " + mur.getStartX() + " mur : " + mur.getId());
						return false;
					}
				}
			}
		}

//		if (action.equals("monte") || action.equals("descent")) {
//
//			for (Line mur : listObstacle) {
//
//				if (aspi.getLayoutY() >= mur.getStartY() && aspi.getLayoutY() <= mur.getEndY()) {
//					System.out.println("Position X : " + mur.getStartX() + " mur : " + mur.getId());
//					if (aspi.getLayoutX() + aspi.getWidth() >= mur.getStartX()
//							&& aspi.getLayoutX() - aspi.getWidth() <= mur.getEndX()) {
//						return false;
//					}
//				}
//			}
//		}
		return true;
	}
}