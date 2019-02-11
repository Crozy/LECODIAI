package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Box;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class MyControlleur extends Thread implements Initializable {

	// 0: Partie non lancé 1: Stop, 2: Go
	private static int stopGo = 0;

	// Elements de l'interface
	@FXML
	private Button myButtonGo;

	@FXML
	private Button myButtonStop = new Button("STOP");

	@FXML
	private TextField myTextField;

	@FXML
	private Label theX;

	@FXML
	private Label theY;

	@FXML
	private Box aspi;

	@FXML
	private Line mur1, mur2, mur3;
	
	@FXML
	private Rectangle trace;

	public Label getTheX() {
		return theX;
	}

	public void setTheX(Label theX) {
		this.theX = theX;
	}

	public Label getTheY() {
		return theY;
	}

	public void setTheY(Label theY) {
		this.theY = theY;
	}

	public Box getAspi() {
		return aspi;
	}

	public void setAspi(Box aspi) {
		this.aspi = aspi;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Récupère l'emplacement de l'aspirateur et l'affiche dans les labels X Y.
		theX.setText(String.valueOf(aspi.getLayoutX()));
		theY.setText(String.valueOf(aspi.getLayoutY()));

		System.out.println("Start Y : " + mur1.getStartY());
		System.out.println("End Y : " + mur1.getEndY());
		System.out.println("Start X : " + mur1.getStartX());
		System.out.println("End X : " + mur1.getEndX());

		myButtonGo = new Button("TEST");

	}

	public void clickButtonGo(ActionEvent event) throws InterruptedException {
		// Vérifie si le thread a été lancé
		if (stopGo == 0) {
			stopGo = 2;
			t.start();
		} else {
			stopGo = 2;
		}
	}

	public void clickButtonStop() throws InterruptedException {
		stopGo = 1;
	}

	// Thread qui fait lancer la partie.
	// Bon j'ai fait un truck sale quand la partie est arreter le thread tourne
	// toujours mais ne fait aucune action.
	Thread t = new Thread() {
		public void run() {

			while (true) { // Je ne suis pas fier de ce truck x)
				while (stopGo == 1) {
					try {
						sleep(100); // Si je met rien dans cette boucle je ne peut pas relancer la partie. Donc a
									// voir.
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					// System.out.println("Partie arreté");
				}
				while (stopGo == 2) {
					// System.out.println("Partie lancé");
					System.out.println("X : " + aspi.getLayoutX() + " Y : " + aspi.getLayoutY());
					try {
						sleep(100);
						if (aspi.getLayoutX() <= mur1.getEndX() + 110) {
							avance();
						} else {
							System.out.println("Aspi : " + aspi.getLayoutX() + " mur : " + mur1.getLayoutX());
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	};

	// Action fournit par le simulateur
	public void avance() {
		Double theX = aspi.getLayoutX();
		trace.setWidth(trace.getWidth() + 1);
		this.aspi.setLayoutX(aspi.getLayoutX() + 1);
	}

	public void recule() {
		this.aspi.setLayoutX(aspi.getLayoutX() - 1);
	}
	
	public Boolean radarNord() {
//		if(aspi.getLayoutY() + 1){
//			
//		}
		return null;		
	}
	
	public Boolean radarSud() {
		return null;		
	}
	public Boolean radarEst() {
		return null;		
	}
	public Boolean radarOuest() {
		return null;		
	}

}