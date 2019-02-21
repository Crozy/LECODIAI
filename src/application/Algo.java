package application;

import java.util.Random;

import classes.Position;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;

public class Algo {

	private Tool outils;
	private int tour;
	private int valeurAlea = 1, valeurAlea2 = 2; // 1: avance, 2: recule, 3: haut, 4: bas
	private String action = "avance", actionprecedente = "avance", actionprecedenteprecedente = "avance";
	private Random aleatoire = new Random();
	private Boolean firstStep = true;
	private Boolean goAlea = false;
	private Position positionGoAlea = new Position(0, 0);

	public Algo(AnchorPane panel, Box aspi) {
		outils = new Tool(panel.getChildren().listIterator());
		valeurAlea = 1 + aleatoire.nextInt(4);
		valeurAlea2 = 100 + aleatoire.nextInt(100);

	}
////////////////////////////////////////////////////////////////////////////
	public void Parti(Box aspi, AnchorPane panel) {
		System.out.println("Alea : " + valeurAlea);
		System.out.println("Tour : " + tour);
		System.out.println("Action : " + action);
		tour++;
		
		if(goAlea == false) {
		if(positionGoAlea.x == aspi.getLayoutX() && positionGoAlea.y == aspi.getLayoutY()) {
		tour = 0;
		goAlea = true;
		return;
	}
		
		if (firstStep) {
			
			//System.out.println(outils.recherche(aspi, "haut"));
			if (action.equals("avance") && outils.recherche(aspi, "avance")) {
				outils.avance(aspi, panel);
				return;
			} else {
				action = "haut";
				firstStep = false;
				positionGoAlea.x = aspi.getLayoutX();
				positionGoAlea.y = aspi.getLayoutY();
				//return;
			}
		}
		

		
		if (action == "haut") {
			if (!outils.recherche(aspi, "avance") && outils.recherche(aspi, "haut")) {
				outils.haut(aspi, panel);
				return;
			} else if (outils.recherche(aspi, "avance")) {
				actionprecedenteprecedente = actionprecedente;
				actionprecedente = action;
				action="avance";
				outils.avance(aspi, panel);
				return;
			} else{
				actionprecedenteprecedente = actionprecedente;
				actionprecedente = action;
				action="recule";
			}
		} else if (action == "avance") {
			if (!outils.recherche(aspi, "bas") && outils.recherche(aspi, "avance")) {
				outils.avance(aspi, panel); 
				return;
			} else if (outils.recherche(aspi, "avance") && outils.recherche(aspi, "recule") && outils.recherche(aspi, "haut") && outils.recherche(aspi, "bas")){
				actionprecedenteprecedente = actionprecedente;
				actionprecedente = action;
				action="bas";
				outils.bas(aspi, panel);
				return;
			} else if (outils.recherche(aspi, "bas")) {
				actionprecedenteprecedente = actionprecedente;
				actionprecedente = action;
				action="bas";
			} else if(!outils.recherche(aspi, "haut")) {
				outils.bas(aspi, panel);
				return;
			}else {
				actionprecedenteprecedente = actionprecedente;
				actionprecedente = action;
				action="recule";
			}
		} else if (action == "bas") {
			System.out.println("Pre : " + actionprecedente + " PREPRE : " + actionprecedenteprecedente);
				if (!outils.recherche(aspi, "recule") && outils.recherche(aspi, "bas")) {
				outils.bas(aspi, panel); 
				return;
			}else if (outils.recherche(aspi, "avance") && outils.recherche(aspi, "recule") && outils.recherche(aspi, "haut") && outils.recherche(aspi, "bas")){
				outils.recule(aspi, panel);
				return;
			}else if (outils.recherche(aspi, "recule")) {
				actionprecedenteprecedente = actionprecedente;
				actionprecedente = action;
				action="recule";
			}else {
				actionprecedenteprecedente = actionprecedente;
				actionprecedente = action;
				action="avance";
			}
		} else if (action == "recule") {
			if (!outils.recherche(aspi, "haut") && outils.recherche(aspi, "recule")) {
				outils.recule(aspi, panel);
				return;
			} else if (outils.recherche(aspi, "avance") && outils.recherche(aspi, "recule") && outils.recherche(aspi, "haut") && outils.recherche(aspi, "bas")){
				outils.haut(aspi, panel);
				return;
			
			}else if (outils.recherche(aspi, "haut")) {
				actionprecedenteprecedente = actionprecedente;
				actionprecedente = action;
				action="haut";
			} else {
				actionprecedenteprecedente = actionprecedente;
				actionprecedente = action;
				action="bas";
			}
		}
		}else {
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		if (tour >= valeurAlea2) {
			tour = 0;
			valeurAlea2 = 100 + aleatoire.nextInt(100);
//			if ((action.equals("avance") || action.equals("recule")) && (outils.recherche(aspi, "haut") || outils.recherche(aspi, "bas"))) {
			if (action.equals("avance") || action.equals("recule")){
				valeurAlea = 3 + aleatoire.nextInt(2);
			}else {
				valeurAlea = 1 + aleatoire.nextInt(2);
			}
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
					outils.avance(aspi, panel);
					break;
				case 2:
					outils.recule(aspi, panel);
					break;
				case 3:
					outils.haut(aspi, panel);
					break;
				case 4:
					outils.bas(aspi, panel);
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
		}
	//	outils.haut(aspi, panel);
		System.out.println("Radar : " + outils.recherche(aspi, "avance"));
	}

}
