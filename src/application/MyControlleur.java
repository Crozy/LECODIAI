package application;

import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class MyControlleur extends Thread implements Initializable {
	
	@FXML
	protected AnchorPane anchorPane;

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
	protected Box aspi;

	@FXML
	private Line mur1, mur2, mur3, mur21;

	private Tool outils;

	private Boolean monte = true;

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
	
	private Algo ia;
	
	private int tour;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		ia = new Algo(anchorPane, aspi);
		theX.setText(String.valueOf(aspi.getLayoutX()));
		theY.setText(String.valueOf(aspi.getLayoutY()));

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
	
	Thread t = new Thread() {
		public void run() {

			while (true) {
				while (stopGo == 1) {
					try {
						sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				while (stopGo == 2) {
					try {
						sleep(1);
						tour++;
						
						//ia.Parti(aspi, anchorPane);
						
						Platform.runLater(() -> {
						ia.Parti(aspi, anchorPane);
						theX.setText(String.valueOf(aspi.getLayoutX()));
						theY.setText(String.valueOf(aspi.getLayoutY()));
						});
						
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
		// trace.setEndX(theX - 110);
		this.aspi.setLayoutX(aspi.getLayoutX() + 1);
	}

	public void recule() {
		this.aspi.setLayoutX(aspi.getLayoutX() - 1);
	}
}