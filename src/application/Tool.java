package application;

import java.util.ArrayList;
import java.util.ListIterator;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Line;

public class Tool {

	private ListIterator<Node> listDesElements;
	private ArrayList<Line> listObstacle = new ArrayList<>();
	private Line trace;
	private Boolean avanceFirts = false;
	private Boolean reculeFirts = false;
	private Boolean hautFirts = false;
	private Boolean basFirts = false;

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

	public void avance(Box aspi, AnchorPane panel) {
		if (avanceFirts == false) {

			avanceFirts = true;
			reculeFirts = false;
			hautFirts = false;
			basFirts = false;

			traceLine(aspi, panel);
		}
		if (recherche(aspi, "avance")) {
			aspi.setLayoutX(aspi.getLayoutX() + 1);
			Platform.runLater(() -> {
				trace.setEndX(aspi.getLayoutX());
			});
		}
	}

	public void recule(Box aspi, AnchorPane panel) {
		if (reculeFirts == false) {

			avanceFirts = false;
			reculeFirts = true;
			hautFirts = false;
			basFirts = false;

			traceLine(aspi, panel);
		}
		if (recherche(aspi, "recule")) {
			Platform.runLater(() -> {
				trace.setEndX(aspi.getLayoutX());
			});
			aspi.setLayoutX(aspi.getLayoutX() - 1);
		}
	}

	public void haut(Box aspi, AnchorPane panel) {
		if (hautFirts == false) {

			avanceFirts = false;
			reculeFirts = false;
			hautFirts = true;
			basFirts = false;

			traceLine(aspi, panel);
		}
		if (recherche(aspi, "haut")) {
			Platform.runLater(() -> {
				trace.setEndY(aspi.getLayoutY());
			});
			aspi.setLayoutY(aspi.getLayoutY() - 1);
		}
	}

	public void bas(Box aspi, AnchorPane panel) {
		if (basFirts == false) {

			avanceFirts = false;
			reculeFirts = false;
			hautFirts = false;
			basFirts = true;

			traceLine(aspi, panel);
		}
		if (recherche(aspi, "bas")) {
			Platform.runLater(() -> {
				trace.setEndY(aspi.getLayoutY());
			});
			aspi.setLayoutY(aspi.getLayoutY() + 1);
		}
	}

	public Boolean recherche(Box aspi, String action) {

		if (action.equals("avance")) {

			ArrayList<Line> listObstacleADroite = new ArrayList<>();

			// Recupere les Line situé a droite de l'aspi
			for (Line result : listObstacle) {
				if (aspi.getLayoutX() < result.getEndX() && (aspi.getLayoutY() >= result.getStartY() && aspi.getLayoutY() <= result.getEndY())) {
					listObstacleADroite.add(result);
				}
			}

			for (Line mur : listObstacleADroite) {

				if (aspi.getLayoutY() + aspi.getHeight() - 10 >= mur.getStartY()
						&& aspi.getLayoutY() - aspi.getHeight() + 10 <= mur.getEndY()) {

					if (aspi.getLayoutX() + aspi.getWidth() - 10 >= mur.getStartX()
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
				if (result.getStartX() < aspi.getLayoutX() && (aspi.getLayoutY() >= result.getStartY() && aspi.getLayoutY() <= result.getEndY())) {
					listObstacleAGauche.add(result);
				}
			}

			for (Line mur : listObstacleAGauche) {

				if (aspi.getLayoutY() + aspi.getHeight() - 10 >= mur.getStartY()
						&& aspi.getLayoutY() - aspi.getHeight() + 10 <= mur.getEndY()) {

					if (aspi.getLayoutX() + aspi.getWidth() - 10 >= mur.getStartX()
							&& aspi.getLayoutX() - aspi.getWidth() + 10 <= mur.getEndX()) {
						System.out.println("Position X : " + mur.getStartX() + " mur : " + mur.getId());
						return false;
					}
				}
			}
		}

		if (action.equals("haut")) {

			ArrayList<Line> listObstacleAHaut = new ArrayList<>();

			// Recupere les Line situé en haut de l'aspi
			for (Line result : listObstacle) {
				if ((result.getStartY() < aspi.getLayoutY()) && (aspi.getLayoutX() >= result.getStartX() && aspi.getLayoutX() <= result.getEndX())) {
					// System.out.println(" mur : " + result.getId());
					listObstacleAHaut.add(result);
				}
			}

			for (Line mur : listObstacleAHaut) {

//				if (aspi.getLayoutY() + aspi.getHeight() >= mur.getStartY()
//						&& aspi.getLayoutY() - aspi.getHeight() <= mur.getEndY()) {
				if (aspi.getLayoutY() + aspi.getHeight() - 10 >= mur.getEndY()
						&& aspi.getLayoutY() - aspi.getHeight() + 10 <= mur.getStartY()) {

					if (aspi.getLayoutX() + aspi.getWidth() - 10 >= mur.getStartX()
							&& aspi.getLayoutX() - aspi.getWidth() + 10 <= mur.getEndX()) {
						System.out.println("Position X : " + mur.getStartX() + " mur : " + mur.getId());
						return false;
					}
				}
			}
		}

		if (action.equals("bas")) {

			ArrayList<Line> listObstacleABas = new ArrayList<>();

			// Recupere les Line situé en bas de l'aspi
			for (Line result : listObstacle) {
				if ((result.getEndY() > aspi.getLayoutY()) && (aspi.getLayoutX() >= result.getStartX() && aspi.getLayoutX() <= result.getEndX())) {
					// System.out.println(" mur : " + result.getId());
					listObstacleABas.add(result);
				}
			}

			for (Line mur : listObstacleABas) {

				if (aspi.getLayoutY() + aspi.getHeight() - 10 >= mur.getStartY()
						&& aspi.getLayoutY() - aspi.getHeight() + 10 <= mur.getEndY()) {

					if (aspi.getLayoutX() + aspi.getWidth() - 10 >= mur.getStartX()
							&& aspi.getLayoutX() - aspi.getWidth() + 10 <= mur.getEndX()) {
						System.out.println("Position X : " + mur.getStartX() + " mur : " + mur.getId());
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private void traceLine(Box aspi, AnchorPane panel) {
		trace = new Line(aspi.getLayoutX(), aspi.getLayoutY(), aspi.getLayoutX(), aspi.getLayoutY());
		trace.setStrokeWidth(10);
		trace.setStroke(Color.GRAY);
		trace.setOpacity(0.5);
		Platform.runLater(() -> {
			panel.getChildren().add(trace);
			//trace.toBack();
			aspi.toFront();
		});
	}
}